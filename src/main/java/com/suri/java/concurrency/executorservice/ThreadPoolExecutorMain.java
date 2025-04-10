package com.suri.java.concurrency.executorservice;

import java.util.concurrent.*;

/**

 https://stackoverflow.com/questions/17659510/core-pool-size-vs-maximum-pool-size-in-threadpoolexecutor
 https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviews/threadpoolexecutor
 https://www.youtube.com/watch?v=ZUWs2U71vvk&t=1166s&ab_channel=Concept%26%26Coding-byShrayansh
 */
public class ThreadPoolExecutorMain {

  public static void main(String[] args) {

    ThreadPoolExecutor ex = new ThreadPoolExecutor(
                                        2,
                                        4,
                                        10,
                                                   TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(2),
            new CustomThreadFactory(), new CustomRejectHandler()
            );
    //ex.allowCoreThreadTimeOut(true); - if we set this then only keep Alive time is applicable

    /* TODO - Try to submit more and more Task and see the behaviour */
    for(int i=1;i<=4;i++){
      ex.submit(()->{
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          // handle exception
        }
        System.out.println("Task processed by :"+Thread.currentThread().getName());
      });
     // ex.submit(new MyTask());
    }
  }
}
class CustomThreadFactory implements ThreadFactory{

  @Override
  public Thread newThread(Runnable r) {
    Thread thread = new Thread(r);
    thread.setPriority(Thread.NORM_PRIORITY);
    thread.setDaemon(false);
    return thread;
  }
}

class CustomRejectHandler implements RejectedExecutionHandler{

  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    System.out.println("Task Rejected :"+ r.toString());
  }
}

class MyTask implements Runnable{

  @Override
  public void run() {

    while(true){
      System.out.println("Running "+Thread.currentThread().getName());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}