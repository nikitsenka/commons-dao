package com.epam.ta.reportportal.entity;

import java.util.ArrayList;

public class ActivityDetails extends JsonbObject {

	private ArrayList<HistoryField> history;

	private Long objectId;

	private String objectName;

	public ActivityDetails() {
	}

	public ActivityDetails(ArrayList<HistoryField> history) {
		this.history = history;
	}

	public ArrayList<HistoryField> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<HistoryField> history) {
		this.history = history;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
