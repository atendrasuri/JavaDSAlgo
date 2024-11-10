package com.suri.java.concurrency.countDownLatch;


import java.util.concurrent.CountDownLatch;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/02/19
 * @Description: (Overwrite)
 * <p>
 * <p>
 * CountDown Latch in Java Concurrency is a type of synchronizer which allows one Thread wait for one or more Threads before it starts processing.
 * <p>
 * CountDown Latch is useful if you want to start main processing threads once its dependency is completed.
 * <p>
 * In this example, Car can start only after all 4 employees take their seat in the car.
 */
public class CarDriver {
    public static void main(String[] args) {


        final CountDownLatch latch = new CountDownLatch(4);
        Employee emp1 = new Employee("EMP1", 1000, latch);
        Employee emp2 = new Employee("EMP2", 1000, latch);
        Employee emp3 = new Employee("EMP3", 1000, latch);
        Employee emp4 = new Employee("EMP4", 1000, latch);

        Thread t1 = new Thread(emp1);
        Thread t2 = new Thread(emp2);
        Thread t3 = new Thread(emp3);
        Thread t4 = new Thread(emp4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            latch.await();
            System.out.println(" All Employees have taken their seat, Driver started the Car ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Employee implements Runnable {

    private final String name;
    private final int timeToReachParking;
    private final CountDownLatch latch;

    public Employee(String name, int timeToReachParking, CountDownLatch latch) {
        this.name = name;
        this.timeToReachParking = timeToReachParking;
        this.latch = latch;
    }


    @Override
    public void run() {

        try {
            Thread.sleep(timeToReachParking);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " has taken the seat");
        latch.countDown();

    }
}