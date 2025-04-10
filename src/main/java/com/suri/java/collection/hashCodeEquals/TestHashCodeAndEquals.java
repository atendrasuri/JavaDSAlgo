package com.suri.java.collection.hashCodeEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 Contract of hashCode(): and equals()

 ```
 The basic rule of the contract states that if two objects are equal to each other based on equals() method,
 then the hash code must be the same,
 but if the hash code is the same, then equals() can return false.That means, if hashcode of two object are same that
 doesn't mean both objects are equal, but if two object are equals by value their hashcode will always same.
 ```

 Consistency: If you call hashCode() multiple times on the same object during the execution of a program, it should always return the same integer value, as long as the object’s state (that is used in hashCode()) doesn’t change.

 Example: If an object’s hashCode() is computed based on a field, that field’s value must not change during the object’s lifetime if the object is going to be used in hash-based collections.
 Equality Consistency: If two objects are equal according to the equals() method, they must return the same hash code.

 Example: If a.equals(b) is true, then a.hashCode() must be equal to b.hashCode(). This is crucial for collections like HashMap and HashSet to work correctly.
 */
public class TestHashCodeAndEquals {
  public static void main(String[] args) {


    HashSet<Employee> employeeSet = new HashSet<>();

    Employee e1 = new Employee(1,"a");
    Employee e2 = new Employee(2,"b");
    Employee e3= new Employee(3,"c");
    Employee e4 = new Employee(1,"d");
    employeeSet.add(e1);
    employeeSet.add(e2);
    employeeSet.add(e3);
    employeeSet.add(e4);
    System.out.println(employeeSet.size());

    HashMap <Employee,String> employeeHashMap = new HashMap<>();
    employeeHashMap.put(e1,"E1");
    employeeHashMap.put(e2,"E2");
    employeeHashMap.put(e3,"E3");
    employeeHashMap.put(e4,"E4");
    e4.setId(5);
    System.out.println(employeeHashMap.size());


    HashSet<Person> personHashSet = new HashSet<>();
    Person p1 = new Person(1,"a");
    Person p2 = new Person(2,"b");
    Person p3 = new Person(3,"c");


    personHashSet.add(p1);
    personHashSet.add(p2);
    personHashSet.add(p3);

    Person h = new Person(1,"a");
    System.out.println(personHashSet.remove(h));
    System.out.println(personHashSet.size());

    Map<Person,String> personHashMap  = new HashMap<>();
    personHashMap.put(p1,"P1");
    personHashMap.put(p2,"P2");
    personHashMap.put(p3,"P3");
    personHashMap.remove(h);
    System.out.println(personHashMap.size());
  }
}