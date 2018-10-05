INSERT INTO activity(id, user_id, project_id, entity, action, details, creation_date) VALUES
(1, 1, 1, 'DASHBOARD', 'dashboard_update', '{
  "type": "com.epam.ta.reportportal.entity.ActivityDetails",
  "history": [
    {
      "field": "name",
      "newValue": "After Name",
      "oldValue": "Before Name"
    },
    {
      "field": "description",
      "newValue": "After Desc",
      "oldValue": "Before Desc"
    }
  ],
  "objectId" : 1,
  "objectName": "name"
}', '2016-06-22 19:10:25-07'),

(2,1,1, 'WIDGET', 'widget_create', '{
  "type": "com.epam.ta.reportportal.entity.ActivityDetails",
  "history": null,
  "objectId": 1,
  "objectName": "widget test"
}', '2018-10-05 17:09:32-01'),

(3, 1, 1, 'FILTER', 'filter_create', '{
  "type": "com.epam.ta.reportportal.entity.ActivityDetails",
  "history": null,
  "objectId": 1,
  "objectName": "filter test"
}', '2018-10-05 17:20:16.501000'),

(4, 2, 2, 'FILTER', 'filter_update', '{
  "type": "com.epam.ta.reportportal.entity.ActivityDetails",
  "history": [
    {
      "field": "name",
      "newValue": "filter new test",
      "oldValue": "filter test"
    },
    {
      "field": "description",
      "newValue": "new",
      "oldValue": "old"
    }
  ],
  "objectId": 1,
  "objectName": "filter new test"
}', '2018-10-05 17:40:03.845000');