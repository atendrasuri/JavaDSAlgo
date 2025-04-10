package com.suri.java.concurrency.atomicAndvolatile;

/**

Both volatile and atomic in Java are used to ensure thread safety, but they serve different purposes.

Feature	         volatile	                                                     Atomic (AtomicInteger, AtomicLong, etc.)
Purpose	         Ensures visibility of updates to variables across threads	     Ensures atomicity for compound operations
Thread Safety	 Provides visibility but not atomicity	                         Provides atomic operations using CAS (Compare-And-Swap)
Operations Supported	Read & write	                                         Increment, decrement, update, compare-and-swap, etc.
Use Case	         Boolean flags, status variables	                         Counters, accumulators, updating shared variables
Synchronization	     No locking, no atomic compound operations	                 No locking, but atomic via CAS
Performance	Faster, but not suitable for modifying values atomically	         Slightly slower due to CAS, but safe for concurrent updates



 */

/**

 When to Use What?
 Use volatile when a variable is only used for flags, state checks, or simple updates (e.g., boolean flag).
 Use AtomicInteger or synchronized when working with incrementing counters or modifying shared data.


 */

/**
 Note -  Declaring an AtomicInteger as volatile does not cause a compilation error in Java. However, it is redundant and unnecessary.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Difference_Between_volatile_and_Atomic {

    public static void main(String[] args) {

    }
}

/**
Let's see why volatile does not ensure atomicity:
 */
class VolatileCounter implements Runnable {
    volatile int count = 0;

    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++; // Not atomic!
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCounter counter = new VolatileCounter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count (Expected: 2000, Actual): " + counter.count);
    }
}


/**
 The AtomicInteger class ensures atomicity using Compare-And-Swap (CAS).
 */

class AtomicCounter implements Runnable {
     AtomicInteger count = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet(); // Atomic operation
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count (Expected: 2000, Actual): " + counter.count.get());
    }
}

