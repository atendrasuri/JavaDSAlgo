package com.suri.java.concurrency.executorservice.customthreadpool;

import java.util.LinkedList;
import java.util.List;

/**

 */
public class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

  private List<E> queue;

  private int maxSize;

  public LinkedBlockingQueueCustom(int maxSize) {
    this.maxSize = maxSize;
    queue = new LinkedList<>();
  }


  @Override
  public synchronized void put(E item) throws InterruptedException {

    while (queue.size() == maxSize) {
      this.wait();
    }
    queue.add(item);
    this.notifyAll();


  }

  @Override
  public synchronized E take() throws InterruptedException {
    while (queue.size() == 0) {
      this.wait();
    }
    this.notifyAll();
    return queue.remove(0);

  }

  @Override
  public synchronized int size() {
    return queue.size();
  }
}