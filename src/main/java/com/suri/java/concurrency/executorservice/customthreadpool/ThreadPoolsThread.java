package com.suri.java.concurrency.executorservice.customthreadpool;

/**

 */
public class ThreadPoolsThread extends Thread {
  private BlockingQueueCustom<Runnable> taskQueue;
  private CustomThreadPool customThreadPool;

  ThreadPoolsThread(BlockingQueueCustom<Runnable> taskQueue, CustomThreadPool customThreadPool) {
    this.taskQueue = taskQueue;
    this.customThreadPool = customThreadPool;
  }

  public void run() {
    try {
      while (true) {
        System.out.println(Thread.currentThread().getName() + " IS READY TO EXECUTE TASK");
        Runnable runnable = taskQueue.take();
        System.out.println(Thread.currentThread().getName() + " Has TAKEN THE TASK");
        runnable.run();
        System.out.println(Thread.currentThread().getName() + " Has EXECUTED THE TASK");
        if (this.customThreadPool.isPoolShutDownInitiated() && this.taskQueue.size() == 0) {
          this.interrupt();
          Thread.sleep(1);
        }
      }
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " has been STOPPED.");
    }
  }
}