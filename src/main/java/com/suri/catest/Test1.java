package com.suri.catest;

import java.util.*;

/*
Given six documents A, B, C, D, E, F and each document has dependency on other documents as given below. Find in which order you will complete reading all documents




public void function1(Map<String, List<String> > map){



for(Map.Entry<String, List<String>> entry: map){

function2(

}


}



public void function2(Map<String, List<String>){





  for(List<String> dependencies : map


}

 */
public class Test1 {
    public static void main(String[] args) {

        System.out.println("Hello");

        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("E","F"));
        map.put("B", Arrays.asList("D","E"));
        map.put("C", Arrays.asList("F"));
        map.put("D", Arrays.asList("C"));
        map.put("E", new ArrayList<>());
        map.put("F", new ArrayList<>());
        function1(map);

    }


    public static void function1(Map<String, List<String>> map){

       Queue<String> order = new LinkedList<>();
       Set<String> visited = new HashSet<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            if(!visited.contains(entry.getKey())) {
                function2(map, entry.getKey(), visited, order);
            }
        }

        while (!order.isEmpty()){
            System.out.println(" "+order.remove());
        }


    }
    /*
A - E, F
B - D, E
C - F
D - C
E - NA
F- NA
     */

    public static void function2(Map<String, List<String>> map, String vertice,  Set<String> visited, Queue<String> order ){
        visited.add(vertice);
        for(String v: map.get(vertice)){
            if(!visited.contains(v)){
                function2(map, v, visited, order);
            }
        }
        order.add(vertice);
    }



}
