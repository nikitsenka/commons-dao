package com.epam.ta.reportportal.commons.querygen;

import com.epam.ta.reportportal.commons.Preconditions;
import com.epam.ta.reportportal.commons.validation.BusinessRule;
import com.epam.ta.reportportal.commons.validation.Suppliers;
import com.epam.ta.reportportal.ws.model.ErrorType;
import org.jooq.Condition;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import static com.epam.ta.reportportal.jooq.tables.JLaunch.LAUNCH;
import static java.util.Optional.ofNullable;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;

/**
 * MongoDB query builder. Constructs MongoDB
 * {@link org.jooq.Query} by provided filters <br>
 * <p>
 * TODO Some interface for QueryBuilder should be created to avoid problems with possible changing
 * of DB engine
 *
 * @author Andrei Varabyeu
 * @author Andrei_Ramanchuk
 */
public class QueryBuilder {

	private DSLContext dsl;

	/**
	 * SQL query representation
	 */
	private SelectQuery<? extends Record> query;

	private QueryBuilder(FilterTarget target) {
		query = target.getQuery();
	}

	private QueryBuilder(SelectQuery<? extends Record> query) {
		this.query = query;
	}

	public static QueryBuilder newBuilder(FilterTarget target) {
		return new QueryBuilder(target);
	}

	public static QueryBuilder newBuilder(Queryable queryable) {
		return new QueryBuilder(queryable.toQuery());
	}

	/**
	 * Adds condition to the query
	 *
	 * @param condition Condition
	 * @return QueryBuilder
	 */
	public QueryBuilder addCondition(Condition condition) {
		query.addConditions(condition);
		return this;
	}

	public QueryBuilder with(boolean latest) {
		if (latest) {
			query.addConditions(LAUNCH.ID.in(DSL.selectDistinct(LAUNCH.ID)
					.on(LAUNCH.NAME)
					.from(LAUNCH)
					.orderBy(LAUNCH.NAME, LAUNCH.NUMBER.desc())));
		}
		return this;
	}

	/**
	 * Adds {@link Pageable} conditions
	 *
	 * @param p Pageable
	 * @return QueryBuilder
	 */
	public QueryBuilder with(Pageable p) {
		query.addLimit(p.getPageSize());
		query.addOffset(Long.valueOf(p.getOffset()).intValue());
		return with(p.getSort());
	}

	/**
	 * Add limit
	 *
	 * @param limit Limit
	 * @return QueryBuilder
	 */
	public QueryBuilder with(int limit) {
		query.addLimit(limit);
		return this;
	}

	/**
	 * Add sorting {@link Sort}
	 *
	 * @param sort Sort condition
	 * @return QueryBuilder
	 */
	public QueryBuilder with(Sort sort) {
		ofNullable(sort).ifPresent(s -> StreamSupport.stream(s.spliterator(), false)
				.forEach(order -> query.addOrderBy(field(name(order.getProperty())).sort(order.getDirection().isDescending() ?
						SortOrder.DESC :
						SortOrder.ASC))));

		return this;
	}

	/**
	 * Builds query
	 *
	 * @return Query
	 */
	public SelectQuery<? extends Record> build() {
		return query;
	}

	public static Function<FilterCondition, Condition> filterConverter(FilterTarget target) {
		return filterCondition -> {
			String searchCriteria = filterCondition.getSearchCriteria();
			Optional<CriteriaHolder> criteriaHolder = target.getCriteriaByFilter(searchCriteria);

			/*
				creates criteria holder for statistics search criteria cause there
				can be custom statistics so we can't know it till this moment
			*/
			if (searchCriteria.startsWith("statistics")) {
				criteriaHolder = Optional.of(new CriteriaHolder(searchCriteria, searchCriteria, Long.class, false));
			}
			BusinessRule.expect(criteriaHolder, Preconditions.IS_PRESENT).verify(
					ErrorType.INCORRECT_FILTER_PARAMETERS,
					Suppliers.formattedSupplier("Filter parameter {} is not defined", searchCriteria)
			);

			Condition condition = filterCondition.getCondition().toCondition(filterCondition, criteriaHolder.get());
			/* Does FilterCondition contains negative=true? */
			if (filterCondition.isNegative()) {
				condition = condition.not();
			}
			return condition;
		};
	}
}