package com.suri.java.collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class StoreEmployeeInSorted {
    public static void main(String[] args) {

        //Set<Employee> employee = new TreeSet<>(Comparator.comparingInt(Employee::getEmpId));

        Set<Employee> employee = new TreeSet<>();

        employee.add(new Employee(1,"A",new Address("s1", "h1")));
        employee.add(new Employee(2,"B",new Address("s2", "h2")));
        employee.add(new Employee(3,"C",new Address("s3", "h3")));
        employee.add(new Employee(4,"D",new Address("s4", "h4")));
        employee.add(new Employee(1,"A",new Address("s1", "h1")));

        System.out.println(employee);

    }
}

class Employee implements Comparable<Employee> {

    private int empId;
    private String empName;
    private Address address;

    public Employee(int empId, String empName, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   /* @Override
    public int compare(Employee o1, Employee o2) {

        if (o2.getEmpId() > o1.getEmpId()) {
            return 1;
        } else if (o2.getEmpId() < o1.getEmpId()) {
            return -1;
        }
        return 0;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && empName.equals(employee.empName) && address.equals(employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getEmpId() > o.getEmpId()) {
            return -1;
        } else if (this.getEmpId() < o.getEmpId()) {
            return 1;
        }
        return 0;
    }
}

class Address{
    private String street;
    private String houseName;

    public Address(String street, String houseName) {
        this.street = street;
        this.houseName = houseName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
