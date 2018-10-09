package com.epam.ta.reportportal.entity.widget.content;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

import static com.epam.ta.reportportal.dao.constant.WidgetContentRepositoryConstants.*;

/**
 * @author Ivan Budayeu
 */
public abstract class AbstractLaunchStatisticsContent implements Serializable {

	@Column(name = ID)
	@JsonProperty(value = "id")
	private Long id;

	@Column(name = NUMBER)
	@JsonProperty(value = "number")
	private Integer number;

	@Column(name = NAME)
	@JsonProperty(value = "name")
	private String name;

	@Column(name = START_TIME)
	@JsonProperty(value = "start_time")
	private Timestamp startTime;

	public AbstractLaunchStatisticsContent() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractLaunchStatisticsContent{");
		sb.append("id=").append(id);
		sb.append(", number=").append(number);
		sb.append(", name='").append(name).append('\'');
		sb.append(", startTime=").append(startTime);
		sb.append('}');
		return sb.toString();
	}
}