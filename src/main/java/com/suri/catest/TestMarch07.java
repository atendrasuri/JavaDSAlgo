package com.suri.catest;

public class TestMarch07 {
    public static void main(String[] args) {

        SharedObject obj1 = new SharedObject();
        SharedObject obj2 = new SharedObject();
        MyThread1 t1 = new MyThread1(obj1, obj2);
        MyThread2 t2 = new MyThread2(obj1, obj2);

        t1.start();
        t2.start();


    }
}

class MyThread1 extends Thread{

    SharedObject obj1;
    SharedObject obj2;
    MyThread1(SharedObject obj1, SharedObject obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run(){
        obj1.m1(obj2);
    }
}

class MyThread2 extends Thread{

    SharedObject obj1;
    SharedObject obj2;
    MyThread2(SharedObject obj1, SharedObject obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run(){
        obj2.m2(obj1);
    }
}



class SharedObject {
    public void  m1(SharedObject obj2) {
        synchronized (this) {
                System.out.println(" I am executing on method 1and waiting for method 2");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException ex){

                }
              obj2.m2(this);
            }

    }

    public void m2(SharedObject obj1) {
        synchronized (this) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
            System.out.println(" I am executing on method 2 and waiting for method 1");
            obj1.m1(this);
        }
    }
}

