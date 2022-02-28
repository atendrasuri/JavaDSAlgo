package com.suri.java.immutable;

/**
 * Immutable class:-
 * <p>
 * Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * Make all fields final and private.
 * Don't allow subclasses to override methods.
 * The simplest way to do this is to declare the class as final.
 * A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * <p>
 * If the instance fields include references to mutable objects, don't allow those objects to be changed:
 * Don't provide methods that modify the mutable objects.
 * Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies.
 * Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 */
class ImmutableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {


        User u = new User("Atendra", "Kumar", new ChildAddress("B-235", "DS-max sherwood", "Bangalore"));

        Address address = u.getAddress();

        System.out.println(address);

        address.setFirstLine("B-236");
        address.setSecondLine("Asset Aura");
        address.setCity("Patna");

        System.out.println(""+ u.getAddress());




    }
}

final class User {

    private final String firstName;
    private final String lastName;
    private final ChildAddress address;


    User(String firstName, String lastName, ChildAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (ChildAddress)address.clone();
    }

}

class Address implements Cloneable {

    String firstLine;
    String secondLine;
    String city;

    public Address(String firstLine, String secondLine, String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }


    @Override
    public String toString() {
        return "Address{" +
                "firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}

/**
 * Option 1:- we will not provide any setter method in Address class, So, that nobody can change the property of Address class. If you will answer this
 * there will be counter question to you , Address class is third party java class and we don't have access of source code od Address class.
 *
 * Soln:- We can create child class of Address class, override all the setter methods and then explicitly throw UnsupportedException from those setter methods.
 *
 *class Address implements Cloneable {
 *
 *     String firstLine;
 *     String secondLine;
 *     String city;
 *
 *     public Address(String firstLine, String secondLine, String city) {
 *         this.firstLine = firstLine;
 *         this.secondLine = secondLine;
 *         this.city = city;
 *     }
 *
 *     public String getFirstLine() {
 *         return firstLine;
 *     }
 *
 *     public String getSecondLine() {
 *         return secondLine;
 *     }
 *
 *     public String getCity() {
 *         return city;
 *     }
 *     public void setFirstLine(String firstLine) {
 *         this.firstLine = firstLine;
 *     }
 *
 *     public void setSecondLine(String secondLine) {
 *         this.secondLine = secondLine;
 *     }
 *
 *     public void setCity(String city) {
 *         this.city = city;
 *     }
 *
 *     public Address clone() throws CloneNotSupportedException {
 *         return (Address) super.clone();
 *     }
 *
 *
 *     @Override
 *     public String toString() {
 *         return "Address{" +
 *                 "firstLine='" + firstLine + '\'' +
 *                 ", secondLine='" + secondLine + '\'' +
 *                 ", city='" + city + '\'' +
 *                 '}';
 *     }
 *
 *
 * }
 *
 *
 *
 */

class ChildAddress extends Address{

    public ChildAddress(String firstLine, String secondLine, String city) {
        super(firstLine, secondLine, city);

    }

    public void setFirstLine(String firstLine) {
        throw new UnsupportedOperationException();
    }

    public void setSecondLine(String secondLine) {
        throw new UnsupportedOperationException();
    }

    public void setCity(String city) {
        throw new UnsupportedOperationException();
    }



}

