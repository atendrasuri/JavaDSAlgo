package com.suri.java.concurrency.executorservice.customthreadpool;

import java.util.concurrent.Executors;

/**
 https://vipulpachauri12.medium.com/design-custom-thread-pool-java-617263ee57ec

 To design a thread pool we need following entities :

 1. Thread Pool : Enqueue the task in blocking queue
 2. Blocking Queue : Stores the tasks
 3. Task Executor : Execute the tasks

 */
public class CustomThreadPool {

  private BlockingQueueCustom<Runnable> blockingQueueCustom;

  private boolean poolShutDownInitiated;

  CustomThreadPool(int nThread) {
    blockingQueueCustom = new LinkedBlockingQueueCustom<>(nThread);

    for (int i = 1; i <= nThread; i++) {

      ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(blockingQueueCustom, this);

      threadPoolsThread.setName("Thread-" + i);
      System.out.println("Thread-" + i + " created in ThreadPool.");
      threadPoolsThread.start();   //start thread
    }
  }

  public synchronized void execute(Runnable task) throws Exception {

    if (this.poolShutDownInitiated) {
      throw new Exception("ThredPool shutdown initited, no further task can be added");
    }

    System.out.println(" Task has been  added");
    this.blockingQueueCustom.put(task);
  }

  public boolean isPoolShutDownInitiated() {
    return poolShutDownInitiated;
  }

  public synchronized void shutdown() {
    this.poolShutDownInitiated = true;
    System.out.println("Threadpool SHUTDOWN initiated");
  }
}