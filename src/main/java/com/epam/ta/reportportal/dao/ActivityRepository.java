package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.entity.Activity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository for {@link com.epam.ta.reportportal.entity.Activity} entity
 *
 * @author Andrei Varabyeu
 */
public interface ActivityRepository extends ReportPortalRepository<Activity, Long>, ActivityRepositoryCustom {

}
