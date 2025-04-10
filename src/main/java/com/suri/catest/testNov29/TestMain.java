package com.suri.catest.testNov29;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {

        SubTask subTask = new SubTask("1", "STORE",
                new Location("456", "Test Point 1"));

        SubTask subTask1 = new SubTask("2", "CUSTOMER",
                null);
        TaskDTO taskDTO = new TaskDTO("Task-A", "Delivery", Arrays.asList(subTask, subTask1));


        List<TaskDTO> list  = Arrays.asList(taskDTO);

        List<SubTask>  subTasks =  list.stream().flatMap(e->e.getSubTasks().stream()).filter(e->e.getStopType().equals("STORE")).collect(Collectors.toList());

        System.out.println(subTasks);

       List<String>  result = taskDTO.getSubTasks().isEmpty()?Collections.EMPTY_LIST: taskDTO.
               getSubTasks().
               stream().
               filter(e->e.getStopType().equals("STORE")).
               filter(e->e.getLocation()!=null).
               map(e-> e.getLocation().getStoreId()).
               collect(Collectors.toList());

        System.out.println(result);
        int a[] = new int[2];






        /*"taskId": "Task-A",
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
    }*/

    }
}
