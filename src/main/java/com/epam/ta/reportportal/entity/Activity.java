package com.epam.ta.reportportal.entity;

import com.epam.ta.reportportal.entity.enums.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Activity table entity
 *
 * @author Andrei Varabyeu
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "activity", schema = "public")
@TypeDef(name = "jsonb", typeClass = JsonMap.class)
@TypeDef(name = "pqsql_enum", typeClass = PostgreSQLEnumType.class)
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 64)
	private Long id;

	@Column(name = "user_id", nullable = false, precision = 32)
	private Long userId;

	@Column(name = "project_id", nullable = false)
	private Long projectId;

	@Column(name = "entity", unique = true, nullable = false)
	@Type(type = "pqsql_enum")
	private Entity entity;

	@Column(name = "action", nullable = false)
	private String action;

	@Column(name = "details")
	@Type(type = "jsonb")
	private Map<Object, Object> details;

	@Column(name = "creation_date")
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map<Object, Object> getDetails() {
		return details;
	}

	public void setDetails(Map<Object, Object> details) {
		this.details = details;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public enum Entity {
		LAUNCH,
		ITEM,
		DASHBOARD,
		DEFECT_TYPE,
		EMAIL_CONFIG,
		EXTERNAL_SYSTEM,
		FILTER,
		IMPORT,
		INTEGRATION,
		ITEM_ISSUE,
		PROJECT,
		SHARING,
		TICKET,
		USER,
		WIDGET
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Activity activity = (Activity) o;
		return Objects.equals(id, activity.id) && Objects.equals(userId, activity.userId) && Objects.equals(projectId, activity.projectId)
				&& entity == activity.entity && Objects.equals(action, activity.action) && Objects.equals(details, activity.details)
				&& Objects.equals(createdAt, activity.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, projectId, entity, action, details, createdAt);
	}

	@Override
	public String toString() {
		return "Activity{" + "id=" + id + ", userId=" + userId + ", projectId=" + projectId + ", entity=" + entity + ", action='" + action
				+ '\'' + ", details=" + details + ", createdAt=" + createdAt + '}';
	}
}
