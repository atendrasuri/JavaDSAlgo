package com.suri.java.collection.hashCodeEquals;

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
public class Person {
  private int id;
  private String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return 21;
  }
}