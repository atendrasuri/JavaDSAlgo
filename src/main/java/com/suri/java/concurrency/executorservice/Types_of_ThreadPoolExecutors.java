package com.suri.java.concurrency.executorservice;

import java.util.concurrent.Executors;

/**

Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package. This class supports the following kinds of methods:
Methods that create and return an ExecutorService set up with commonly useful configuration settings.
Methods that create and return a ScheduledExecutorService set up with commonly useful configuration settings.
Methods that create and return a "wrapped" ExecutorService, that disables reconfiguration by making implementation-specific methods inaccessible.
Methods that create and return a ThreadFactory that sets newly created threads to a known state.
Methods that create and return a Callable out of other closure-like forms, so they can be used in execution methods requiring Callable.

 */
public class Types_of_ThreadPoolExecutors {
    public static void main(String[] args) {

        /**
         Creates an Executor that uses a single worker thread operating off an unbounded queue. (Note however that if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time. Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor is guaranteed not to be reconfigurable to use additional threads.
         Returns:
         the newly created single-threaded Executo
         */
        Executors.newSingleThreadExecutor();

        /**
         Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue. At any point, at most nThreads threads will be active processing tasks. If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available. If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. The threads in the pool will exist until it is explicitly shutdown.
         Params:
         nThreads – the number of threads in the pool
         Returns:
         the newly created thread pool
         Throws:
         IllegalArgumentException – if nThreads <= 0
         */
        Executors.newFixedThreadPool(2);

        /**
         Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks. Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. Threads that have not been used for sixty seconds are terminated and removed from the cache. Thus, a pool that remains idle for long enough will not consume any resources. Note that pools with similar properties but different details (for example, timeout parameters) may be created using ThreadPoolExecutor constructors.
         Returns:
         the newly created thread pool
         */
        Executors.newCachedThreadPool();

        /**
         Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
         Params:
         corePoolSize – the number of threads to keep in the pool, even if they are idle
         Returns:
         the newly created scheduled thread pool
         Throws:
         IllegalArgumentException – if corePoolSize < 0
         */
        Executors.newScheduledThreadPool(2);





    }
}
