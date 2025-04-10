package com.suri.java.concurrency.executorservice.customthreadpool;

/**

 */
public class ThreadPoolTest {
  public static void main(String[] args) throws Exception {
    CustomThreadPool customThreadPool = new CustomThreadPool(2);
    Runnable task = new Task();

    customThreadPool.execute(task);
    customThreadPool.execute(task);

    customThreadPool.shutdown();
  }
}