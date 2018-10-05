package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Condition;
import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.commons.querygen.FilterCondition;
import com.epam.ta.reportportal.config.TestConfiguration;
import com.epam.ta.reportportal.entity.Activity;
import com.epam.ta.reportportal.entity.ActivityDetails;
import com.epam.ta.reportportal.entity.HistoryField;
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

	@Test
	public void findByProjectIdTest() {
		List<Activity> activities = repository.findActivitiesByProjectId(1L, defaultFilter(), PageRequest.of(0, 10));
		assertEquals(3, activities.size());
		activities.forEach(a -> assertEquals(Long.valueOf(1L), a.getProjectId()));
	}

	@Rollback(false)
	@Test
	public void test() {
		Activity activity = new Activity();
		activity.setProjectId(2L);
		activity.setUserId(2L);
		activity.setEntity(Activity.Entity.FILTER);
		activity.setAction("filter_updated");
		activity.setCreatedAt(LocalDateTime.now());

		ActivityDetails details = new ActivityDetails();
		details.setObjectId(1L);
		details.setObjectName("filter new test");

		ArrayList<HistoryField> objects = Lists.newArrayList();

		objects.add(new HistoryField("name", "filter test", "filter new test"));
		objects.add(new HistoryField("description", "old", "new"));
		details.setHistory(objects);

		activity.setDetails(details);
		repository.save(activity);
	}

	private Filter filterGetById(long id) {
		return Filter.builder()
				.withCondition(new FilterCondition(Condition.EQUALS, false, String.valueOf(id), "id"))
				.withTarget(Activity.class)
				.build();
	}

	private Filter defaultFilter() {
		return Filter.builder()
				.withCondition(FilterCondition.builder()
						.withCondition(Condition.LOWER_THAN)
						.withSearchCriteria("id")
						.withValue("100")
						.build())
				.withTarget(Activity.class)
				.build();
	}
}