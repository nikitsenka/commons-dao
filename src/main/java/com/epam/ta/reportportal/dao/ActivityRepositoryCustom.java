package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.entity.Activity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.Duration;
import java.util.List;

public interface ActivityRepositoryCustom extends FilterableRepository<Activity> {

	/**
	 * Find activities for specified test item
	 *
	 * @param testItemId ID of Item
	 * @param filter     Filtering details
	 * @param pageable   Paging details
	 * @return Found Activities
	 */
	List<Activity> findActivitiesByTestItemId(String testItemId, Filter filter, Pageable pageable);

	/**
	 * Find activities for specified project
	 *
	 * @param projectId ID of project
	 * @param filter    Filtering details
	 * @param pageable  Paging details
	 * @return Found Activities
	 */
	List<Activity> findActivitiesByProjectId(String projectId, Filter filter, Pageable pageable);

	/**
	 * Delete outdated activities
	 *
	 * @param projectId ID of project
	 * @param period    Time period
	 */
	void deleteModifiedLaterAgo(String projectId, Duration period);

	/**
	 * Find limiting count of results
	 *
	 * @param filter Filtering details
	 * @param sort   Sorting details
	 * @param limit  Results max count
	 * @return Found Activities
	 */
	List<Activity> findByFilterWithSortingAndLimit(Filter filter, Sort sort, int limit);

	/**
	 * Find by field 'objectRef'
	 *
	 * @param objectRef ObjectRef value
	 * @return Found Activities
	 */
	List<Activity> findByLoggedObjectRef(String objectRef);
}
