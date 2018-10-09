package com.epam.ta.reportportal.entity.widget.content;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

import static com.epam.ta.reportportal.dao.constant.WidgetContentRepositoryConstants.*;

/**
 * @author Ivan Budayeu
 */
public class ActivityContent implements Serializable {

	@Column(name = ID)
	@JsonProperty(value = ID)
	private Long activityId;

	@Column(name = PROJECT_ID)
	@JsonProperty(value = PROJECT_ID)
	private Long projectId;

	@Column(name = ACTION_TYPE)
	@JsonProperty(value = ACTION_TYPE)
	private String actionType;

	@Column(name = ENTITY)
	@JsonProperty(value = ENTITY)
	private String entity;

	@Column(name = PROJECT_NAME)
	@JsonProperty(value = PROJECT_NAME)
	private String projectName;

	@Column(name = USER_LOGIN)
	@JsonProperty(value = "user")
	private String userLogin;

	@Column(name = LAST_MODIFIED)
	@JsonProperty(value = LAST_MODIFIED)
	private Timestamp lastModified;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
}