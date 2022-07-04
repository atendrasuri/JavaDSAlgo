package com.suri.catest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestMarch30 {
    public static void main(String[] args) {


        BlockingQueue<Integer> sharedObject = new LinkedBlockingQueue<>();
        int capacity = 50;

        Thread producerThread = new Thread( new Producer(sharedObject, capacity));

        Thread consumerThread1 = new Thread( new Consumer(sharedObject, capacity));

        Thread consumerThread2 = new Thread( new Consumer(sharedObject, capacity));
        Thread consumerThread3 = new Thread( new Consumer(sharedObject, capacity));

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();





    }
}

class Producer  implements Runnable{
    private  BlockingQueue<Integer> sharedObject;
    int capacity;
    Producer( BlockingQueue<Integer> sharedObject, int capacity){
        this.sharedObject = sharedObject;
        this.capacity =capacity;
    }

    public void run(){
       // synchronized (sharedObject) {
            for (int i = 0; i < 100; i++) {
                if (sharedObject.size() >= capacity) {
                   /* try {
                        sharedObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                }else{
                    sharedObject.add(i);
                   /* try {
                        //Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //sharedObject.notifyAll();
                }

            }
       // }
    }

}

//


class Consumer implements Runnable{

    private BlockingQueue<Integer> sharedObject;
    private int capacity;
    Consumer(BlockingQueue<Integer> sharedObject, int capacity){
        this.sharedObject = sharedObject;
        this.capacity = capacity;
    }

    @Override
    public void run() {

        //synchronized (sharedObject){
            while (true){

                if(sharedObject.isEmpty()){
                    /*try {
                        sharedObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }else{

                    System.out.println(Thread.currentThread().getName()+" printing "+sharedObject.remove());
                   /* try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //sharedObject.notifyAll();
                }
            }
        }

    //}
}


