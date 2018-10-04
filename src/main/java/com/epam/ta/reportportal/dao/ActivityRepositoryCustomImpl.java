package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.commons.querygen.QueryBuilder;
import com.epam.ta.reportportal.dao.util.JsonbConverter;
import com.epam.ta.reportportal.entity.Activity;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.epam.ta.reportportal.jooq.tables.JActivity.ACTIVITY;

@Repository
public class ActivityRepositoryCustomImpl implements ActivityRepositoryCustom {

	private static final RecordMapper<? super Record, Activity> ACTIVITY_MAPPER = r -> {
		Activity activity = new Activity();

		activity.setId(r.get(ACTIVITY.ID));
		activity.setAction(r.get(ACTIVITY.ACTION));
		activity.setEntity(r.get(ACTIVITY.ENTITY, Activity.Entity.class));
		activity.setUserId(r.get(ACTIVITY.USER_ID));
		activity.setProjectId(r.get(ACTIVITY.PROJECT_ID));
		activity.setCreatedAt(r.get(ACTIVITY.CREATION_DATE, LocalDateTime.class));
		activity.setDetails(r.get(ACTIVITY.DETAILS, new JsonbConverter()));

		return activity;
	};

	private static final Function<Result<? extends Record>, List<Activity>> ACTIVITIES_FETCHER = r -> {
		Map<Long, Activity> activityMap = Maps.newHashMap();
		r.forEach(res -> {
			Long activityId = res.get(ACTIVITY.ID);
			if (!activityMap.containsKey(activityId)) {
				activityMap.put(activityId, ACTIVITY_MAPPER.map(res));
			}
		});

		return Lists.newArrayList(activityMap.values());
	};

	private DSLContext dsl;

	@Autowired
	public ActivityRepositoryCustomImpl(DSLContext dsl) {
		this.dsl = dsl;
	}

	@Override
	public List<Activity> findActivitiesByTestItemId(String testItemId, Filter filter, Pageable pageable) {
		return null;
	}

	@Override
	public List<Activity> findActivitiesByProjectId(String projectId, Filter filter, Pageable pageable) {
		return null;
	}

	@Override
	public void deleteModifiedLaterAgo(String projectId, Duration period) {

	}

	@Override
	public List<Activity> findByFilterWithSortingAndLimit(Filter filter, Sort sort, int limit) {
		return null;
	}

	@Override
	public List<Activity> findByLoggedObjectRef(String objectRef) {
		return null;
	}

	@Override
	public List<Activity> findByFilter(Filter filter) {
		return ACTIVITIES_FETCHER.apply(dsl.fetch(QueryBuilder.newBuilder(filter).build()));
	}

	@Override
	public Page<Activity> findByFilter(Filter filter, Pageable pageable) {
		return PageableExecutionUtils.getPage(
				dsl.fetch(QueryBuilder.newBuilder(filter).with(pageable).build()).map(ACTIVITY_MAPPER),
				pageable,
				() -> dsl.fetchCount(QueryBuilder.newBuilder(filter).build())
		);
	}
}
