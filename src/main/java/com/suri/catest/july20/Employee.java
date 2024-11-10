package com.suri.catest.july20;

import java.util.Objects;

public class Employee  extends Person {
    private final String role;


    public Employee(int age, String name, String role) {
        super(age, name);
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return role.equals(employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}