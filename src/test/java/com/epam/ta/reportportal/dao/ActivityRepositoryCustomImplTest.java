package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Condition;
import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.commons.querygen.FilterCondition;
import com.epam.ta.reportportal.config.TestConfiguration;
import com.epam.ta.reportportal.entity.Activity;
import com.epam.ta.reportportal.entity.ActivityDetails;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional("transactionManager")
@Sql("/test-activities-fill.sql")
public class ActivityRepositoryCustomImplTest {

	@Autowired
	ActivityRepository repository;

	@Test
	public void findByFilterTest() {
		List<Activity> activities = repository.findByFilter(filterGetById(1));

		assertEquals(1, activities.size());
		assertNotNull(activities.get(0));
	}

	@Test
	public void findByFilterPageableTest() {
		Page<Activity> page = repository.findByFilter(filterGetById(1), PageRequest.of(0, 10));
		ArrayList<Object> activities = Lists.newArrayList();
		page.forEach(a -> activities.add(a));

		assertEquals(1, activities.size());
		assertNotNull(activities.get(0));
	}

	private Filter filterGetById(long id) {
		return Filter.builder()
				.withCondition(new FilterCondition(Condition.EQUALS, false, String.valueOf(id), "id"))
				.withTarget(Activity.class)
				.build();
	}

	@Rollback(false)
	@Test
	public void test() {
		Activity activity = new Activity();
		activity.setProjectId(1L);
		activity.setUserId(1L);
		activity.setEntity(Activity.Entity.WIDGET);
		activity.setAction("widget_create");
		activity.setCreatedAt(LocalDateTime.now());

		ActivityDetails details = new ActivityDetails();
		details.setObjectId(1L);
		details.setObjectName("widget test");

/*		ArrayList<HistoryField> objects = Lists.newArrayList();

		objects.add(new HistoryField("field", "old", "new"));*//*
		details.setHistory(objects);*/
		activity.setDetails(details);
		repository.save(activity);
	}
}