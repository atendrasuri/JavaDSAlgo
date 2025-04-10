package com.suri.catest.testNov29;

import java.util.List;

public class TaskDTO {

    private String taskId;

    private String taskName;

    private List<SubTask> subTasks;

    public TaskDTO(String taskId, String taskName, List<SubTask> subTasks) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.subTasks = subTasks;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }







    /*
    "taskId": "Task-A",
  "taskName": "Delivery",
  "subTasks": [
    {
      "subTaskId": "1",
      "stopType": "STORE",
      "location": {
        "storeId": "456",
        "address": "Test Point 1"
      }
    },
    {
      "subTaskId": "2",
      "stopType": "CUSTOMER",
      "location": {
        "storeId": "457",
        "address": "Test Point 2"
      }
    }
  ]
}
     */


}
