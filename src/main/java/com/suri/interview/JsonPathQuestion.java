package com.suri.interview;

import java.util.List;


public class JsonPathQuestion {


    public static void main(String[] args) {

        String json = "[{\"id\":1,\"name\":\"abc\",\"details\":[{\"id\":1,\"city\":\"Bangalore\",\"state\":\"Karnataka\"},{\"id\":10,\"city\":\"Bangalore123\",\"state\":\"Karnataka\"}]},{\"id\":2,\"name\":\"abc1\",\"details\":[{\"id\":1,\"city\":\"Patna\",\"state\":\"Karnataka\"},{\"id\":1,\"city\":\"Patna\",\"state\":\"Karnataka\"}]}]";

        //List<Object> filteredData = JsonPath.read(json, "$.[?(@.details[?(@.city == 'Bangalore')])]");

        //System.out.println("Filtered JSON: " + filteredData);

    }


    /**

    [
  {
    "id": 1,
    "name": "abc",
    "details": [
      { "id": 1, "city": "Bangalore", "state": "Karnataka" },
      { "id": 10, "city": "Bangalore123", "state": "Karnataka" }
    ]
  },
  {
    "id": 2,
    "name": "abc1",
    "details": [
      { "id": 1, "city": "Patna", "state": "Karnataka" },
      { "id": 1, "city": "Patna", "state": "Karnataka" }
    ]
  }
]
   Question- you have given nested json and now you have to filter the object based on city name, how you can do in best optimized way ?

   Solution -

     1. Using Jackson (Recommended)-   JsonNode rootArray = objectMapper.readTree(json);

     2.Using JsonPath (For Large JSON)

     String json = "[{\"id\":1,\"name\":\"abc\",\"details\":[{\"id\":1,\"city\":\"Bangalore\",\"state\":\"Karnataka\"},{\"id\":10,\"city\":\"Bangalore123\",\"state\":\"Karnataka\"}]},{\"id\":2,\"name\":\"abc1\",\"details\":[{\"id\":1,\"city\":\"Patna\",\"state\":\"Karnataka\"},{\"id\":1,\"city\":\"Patna\",\"state\":\"Karnataka\"}]}]";

     List<Object> filteredData = JsonPath.read(json, "$.[?(@.details[?(@.city == 'Bangalore')])]");

     System.out.println("Filtered JSON: " + filteredData);

     */
}
