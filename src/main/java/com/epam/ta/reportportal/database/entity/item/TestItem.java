package com.epam.ta.reportportal.database.entity.item;

import com.epam.ta.reportportal.database.entity.enums.TestItemTypeEnum;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Pavel Bortnik
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "test_item", schema = "public", indexes = { @Index(name = "test_item_pk", unique = true, columnList = "id ASC") })
public class TestItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 64)
	private Long id;

	@Column(name = "name", length = 256)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TestItemTypeEnum type;

	@Column(name = "start_time", nullable = false)
	private Timestamp startTime;

	@Column(name = "description")
	private String description;

	@LastModifiedDate
	@Column(name = "last_modified", nullable = false)
	private Timestamp lastModified;

	@Column(name = "parameters")
	private Parameter[] parameters;

	@Column(name = "unique_id", nullable = false, length = 256)
	private String uniqueId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestItemTypeEnum getType() {
		return type;
	}

	public void setType(TestItemTypeEnum type) {
		this.type = type;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public Parameter[] getParameters() {
		return parameters;
	}

	public void setParameters(Parameter[] parameters) {
		this.parameters = parameters;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TestItem testItem = (TestItem) o;
		return Objects.equals(id, testItem.id) && Objects.equals(name, testItem.name) && type == testItem.type && Objects.equals(
				startTime, testItem.startTime) && Objects.equals(description, testItem.description) && Objects.equals(
				lastModified, testItem.lastModified) && Arrays.equals(parameters, testItem.parameters) && Objects.equals(
				uniqueId, testItem.uniqueId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, type, startTime, description, lastModified, parameters, uniqueId);
	}

	@Override
	public String toString() {
		return "TestItem{" + "id=" + id + ", name='" + name + '\'' + ", type=" + type + ", startTime=" + startTime + ", description='"
				+ description + '\'' + ", lastModified=" + lastModified + ", parameters=" + Arrays.toString(parameters) + ", uniqueId='"
				+ uniqueId + '\'' + '}';
	}
}