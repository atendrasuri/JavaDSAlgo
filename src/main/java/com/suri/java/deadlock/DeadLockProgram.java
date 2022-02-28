package com.suri.java.deadlock;

import java.awt.*;
import java.sql.SQLOutput;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 12/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */


class Shared{
    public synchronized void m1( Shared s2){
        System.out.println(" I am performing action in m1 method");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s2.m2(this);
    }

    public synchronized void m2( Shared s1){


        System.out.println(" I am performing action in m2 method");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s1.m1(this);
    }
}


class Thread1 extends  Thread{

    private Shared s1;

    private Shared s2;

    Thread1(Shared s1, Shared s2){
        this.s1=s1;
        this.s2=s2;
    }

public void run(){
        s1.m1(s2);
}
}


class Thread2 extends  Thread{

    private Shared s1;

    private Shared s2;

    Thread2(Shared s1, Shared s2){
        this.s1=s1;
        this.s2=s2;
    }

    public void run(){
        s2.m2(s1);
    }
}
public class DeadLockProgram {

    public static void main(String[] args) {
        Shared s1= new Shared();
        Shared s2= new Shared();
        Thread1 t1= new Thread1(s1,s2);
        Thread2 t2= new Thread2(s1,s2);

        t1.start();
        t2.start();
    }
}