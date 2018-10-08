package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Condition;
import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.commons.querygen.FilterCondition;
import com.epam.ta.reportportal.commons.querygen.QueryBuilder;
import com.epam.ta.reportportal.entity.Activity;
import com.epam.ta.reportportal.entity.JsonbObject;
import com.epam.ta.reportportal.exception.ReportPortalException;
import com.epam.ta.reportportal.ws.model.ErrorType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.epam.ta.reportportal.jooq.tables.JActivity.ACTIVITY;
import static java.util.Optional.ofNullable;

public class ActivityRepositoryCustomImpl implements ActivityRepositoryCustom {

	private DSLContext dsl;

	private ObjectMapper objectMapper;

	@Autowired
	public ActivityRepositoryCustomImpl(DSLContext dsl, ObjectMapper objectMapper) {
		this.dsl = dsl;
		this.objectMapper = objectMapper;
	}

	private final RecordMapper<? super Record, Activity> ACTIVITY_MAPPER = r -> {
		Activity activity = new Activity();

		activity.setId(r.get(ACTIVITY.ID));
		activity.setUserId(r.get(ACTIVITY.USER_ID));
		activity.setProjectId(r.get(ACTIVITY.PROJECT_ID));
		activity.setAction(r.get(ACTIVITY.ACTION));
		activity.setEntity(r.get(ACTIVITY.ENTITY, Activity.Entity.class));
		activity.setCreatedAt(r.get(ACTIVITY.CREATION_DATE, LocalDateTime.class));

		String detailsJson = r.get(ACTIVITY.DETAILS, String.class);
		ofNullable(detailsJson).ifPresent(s -> {
			try {
				JsonbObject details = objectMapper.readValue(s, JsonbObject.class);
				activity.setDetails(details);
			} catch (IOException e) {
				throw new ReportPortalException(ErrorType.UNCLASSIFIED_REPORT_PORTAL_ERROR);
			}
		});

		return activity;
	};

	private final Function<Result<? extends Record>, List<Activity>> ACTIVITY_FETCHER = r -> {
		Map<Long, Activity> activityMap = Maps.newHashMap();
		r.forEach(res -> {
			Long activityId = res.get(ACTIVITY.ID);
			if (!activityMap.containsKey(activityId)) {
				activityMap.put(activityId, ACTIVITY_MAPPER.map(res));
			}
		});

		return Lists.newArrayList(activityMap.values());
	};

	@Override
	public List<Activity> findActivitiesByTestItemId(Long testItemId, Filter filter, Pageable pageable) {
		Sort sort = new Sort(Sort.Direction.DESC, "creation_date");
		SelectQuery<? extends Record> query = QueryBuilder.newBuilder(filter).with(sort).with(pageable).build();
		String qqq = query.getSQL();
		int pos = qqq.indexOf("order by");
		String sql = qqq.substring(0, pos) + "and details @> '{\"objectId\" : 1}' " + qqq.substring(pos);
		return null;
	}

	@Override
	public List<Activity> findActivitiesByProjectId(Long projectId, Filter filter, Pageable pageable) {
		FilterCondition projectIdCondition = FilterCondition.builder()
				.withCondition(Condition.EQUALS)
				.withSearchCriteria("project_id")
				.withValue(projectId.toString())
				.build();
		return ACTIVITY_FETCHER.apply(dsl.fetch(QueryBuilder.newBuilder(filter.withCondition(projectIdCondition)).with(pageable).build()));
	}

	@Override
	public void deleteModifiedLaterAgo(Long projectId, Duration period) {
		LocalDateTime bound = LocalDateTime.now().minus(period);
		dsl.delete(ACTIVITY).where(ACTIVITY.PROJECT_ID.eq(projectId)).and(ACTIVITY.CREATION_DATE.lt(Timestamp.valueOf(bound))).execute();
	}

	@Override
	public List<Activity> findByFilterWithSortingAndLimit(Filter filter, Sort sort, int limit) {
		return ACTIVITY_FETCHER.apply(dsl.fetch(QueryBuilder.newBuilder(filter).with(sort).with(limit).build()));
	}

	@Override
	public List<Activity> findByFilter(Filter filter) {
		return ACTIVITY_FETCHER.apply(dsl.fetch(QueryBuilder.newBuilder(filter).build()));
	}

	@Override
	public Page<Activity> findByFilter(Filter filter, Pageable pageable) {
		QueryBuilder queryBuilder = QueryBuilder.newBuilder(filter);
		return PageableExecutionUtils.getPage(dsl.fetch(queryBuilder.with(pageable).build()).map(ACTIVITY_MAPPER),
				pageable,
				() -> dsl.fetchCount(queryBuilder.build())
		);
	}
}
