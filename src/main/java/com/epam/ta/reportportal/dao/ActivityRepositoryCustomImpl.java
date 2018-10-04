package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.entity.Activity;
import com.epam.ta.reportportal.jooq.enums.JActivityEntityEnum;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.epam.ta.reportportal.jooq.tables.JActivity.ACTIVITY;

@Repository
public class ActivityRepositoryCustomImpl implements ActivityRepositoryCustom {

	private static final RecordMapper<? super Record, Activity> ACTIVITY_MAPPER = r -> {
		Activity activity = new Activity();

		activity.setId(r.get(ACTIVITY.ID));
		activity.setAction(r.get(ACTIVITY.ACTION));
		activity.setEntity(r.get(ACTIVITY.ENTITY, Activity.Entity.class));

		return activity;
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
}
