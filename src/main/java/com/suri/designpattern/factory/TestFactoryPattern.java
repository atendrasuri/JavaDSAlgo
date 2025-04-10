package com.suri.designpattern.factory;

/**

 */

interface Vechicle {

    void drive();


}

class Car implements Vechicle {

    @Override
    public void drive() {
        System.out.println("I am under Car class");

    }
}

class MotorCycle implements Vechicle {

    @Override
    public void drive() {
        System.out.println("I am under Motorcycle");

    }
}

class VechicleFactory {


    public static Vechicle getVechicle(String vechicletype) {

        if ("Car".equalsIgnoreCase(vechicletype)) {
            return new Car();
        } else if ("MoterCycle".equalsIgnoreCase(vechicletype)) {
            return new MotorCycle();
        }
        return null;
    }
}


public class TestFactoryPattern {

    public static void main(String[] args) {


        Vechicle car = VechicleFactory.getVechicle("Car");
        car.drive();

        Vechicle motorcycle = VechicleFactory.getVechicle("MoterCycle");

        motorcycle.drive();
    }
}