package com.suri.leetcode.medium;

import java.util.*;

/*
You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.



Example 1:


Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
Example 2:


Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
Output: -3
Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
Thus, the total importance value of employee 5 is -3.
https://leetcode.com/problems/employee-importance/description
 */
public class Soln_690_Employee_Importance {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 5;
        emp1.subordinates = Arrays.asList(2, 3);

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = new ArrayList<>();

        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        emp3.subordinates = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.println(getImportance(employees, 1));

    }

    public static int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int importance =0;
        while(!queue.isEmpty()){
            Employee employee = map.get(queue.remove());
            importance+= employee.importance;
            queue.addAll(employee.subordinates);

        }
        return importance;

    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
