package com.suri.catest.july20;

public class Test {
    public static void main(String[] args) {


        Employee e1 = new Employee(25, "A", "SSE");
        Employee e2 = new Employee(25, "A", "SSE");

        Employee e3 = new Employee(25, "B", "SSE");
        Employee e4 = new Employee(25, "A", "SSE");

        System.out.println(e3.equals(e4));

        System.out.println(e1 + " " + e2);
        System.out.println(e1.equals(e2));

        Person p1 = new Person(25, "A");
        Person p2 = new Person(25, "A");
        System.out.println(p1.equals(e1));

        System.out.println(p1.equals(p2));


    }
    }