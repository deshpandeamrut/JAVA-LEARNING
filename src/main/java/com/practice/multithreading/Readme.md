# JAVA Threads
There are two ways to create a thread:

 - extends Thread class
 - implement Runnable interface
##### Difference in both the approaches

- Creating by implementing runnable is preferred way
- Instantiating an interface gives a cleaner separation between your code and the implementation of threads.
- Runnable instance helps in reusing the thread
- Java only supports single inheritance, so you can only extend one class.
- 


## Dameon vs User Threads
Daemon threads are low priority threads which always run in background and user threads are high priority threads which always run in foreground. User Thread or Non-Daemon are designed to do specific or complex task where as daemon threads are used to perform supporting tasks.
 - JVM will not force the user threads to terminate. It will wait for user threads to terminate themselves. On the other hand, JVM will force the daemon threads to terminate if all the user threads have finished their task.
 - Daemon threads can be created by setting setDaemon flag to true on Thread object

## Thread Priority
Every thread in Java has a priority that helps the thread scheduler to determine the order in which threads scheduled. The threads with higher priority will usually run before and more frequently than lower priority threads. By default, all the threads had the same priority, i.e., they regarded as being equally distinguished by the scheduler, when a thread created it inherits its priority from the thread that created it.

- Default priority of a thread is 5 (NORM_PRIORITY). 
- The value of MIN_PRIORITY is 1 
- MAX_PRIORITY is 10.
- Note: This is not guaranteed

## Thread Scheduler
Thread scheduler in java is the part of the JVM that decides which thread should run. The thread scheduler mainly uses preemptive or time slicing scheduling to schedule the threads.

**Preemptive scheduling**: The highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence.

**Time slicing**: A task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on priority and other factors.

## Deadlock 
Deadlock is a programming situation where two or more threads are blocked forever, this situation arises with at least two threads and two or more resources.
#### Necessary Conditions 
1. Wait & Hold - Waiting for new resource with already holding one resource
2. No Preemtion - No forcefull snatching of resources
3. Circular Wait - A set of threads are waiting for resource in circular order 
    ex; t1 with R2 -> R1 , t2   with R1 -> R2
4. Mutual Eclusion - There is one set of resource and is non-shareable

## Thread pool
It is a group of threads created to eecute a set of tasks. It helps in reducing the time needed to create new threads and hence making the application more responsive

Executor framework helps in acheiving this in Java.
We need to create a set of tasks and create a thread pool with some number and ask the executor service to execute them.

# Volatile
##### Problem
If you have a variable say a counter that is being worked on by a thread, it is possible the thread keeps a copy of the counter variable in the CPU cache and manipulates it rather than writing to the main memory. The JVM will decide when to update the main memory with the value of the counter, even though other threads may read the value of the counter from the main memory and may end up reading a stale value.

##### Solution
If a variable is declared volatile then whenever a thread writes or reads to the volatile variable, the read and write always happen in the main memory.

##### Example
``` 
public class VolatileExample {

    boolean flag = false;
    
    void threadA() {
        while (!flag) { // if this read read a stale value then the loop will be forever
            // ... Do something useful
        }
    }

    void threadB() {
        flag = true; 
        // or if this read writes to the cache then the actual value is inconsistentin main meory and cache
    }
}
```
#### When to use **volatile**?
- volatile will not make a variable thread safe
- volatile should only be used when you  know single thread writes to it and mutiple other threads read from it
- 
## Thread Safe
A class and its public APIs are labeled as thread safe if multiple threads can consume the exposed APIs without causing race conditions or state corruption for the class.

## Synchronized
Synchronization means coordination between multiple threads/processes

There are two types of synchronization that are as follows:

1. Process synchronization
2. Thread synchronization - one thread using resource to eecute and rest of them in waiting state

Thread Synchronization can be of 2 types
1. Mutual Exclusive
	    i. Synchronized Method - applied on method
        ii. Synchronized Block - applied around few line of code
        iii. Static Synchronization - applied on a static class
2. InterThread Communication

- Java’s most fundamental construct for thread synchronization is the synchronized keyword. 
- It can be used to restrict access to critical sections one thread at a time.

**Each object in Java has an entity associated with it called the "monitor lock" or just monitor.** Think of it as an exclusive lock. Once a thread gets hold of the monitor of an object, it has exclusive access to all the methods marked as synchronized. No other thread will be allowed to invoke a method on the object that is marked as synchronized and will block, till the first thread releases the monitor which is equivalent of the first thread exiting the synchronized method.

**Note carefully**
- For static methods, the monitor will be the class object, which is distinct from the monitor of each instance of the same class.
- If an uncaught exception occurs in a synchronized method, the monitor is still released.
- Furthermore, synchronized blocks can be re-entered.
- When thread enters into synchronized instance method or block, it acquires Object level lock and when it enters into synchronized static method or block it acquires class level lock.
Java synchronization will throw null pointer exception if Object used in synchronized block is null. For example, If in synchronized(instance) , instance is null then it will throw null pointer exception.

#### Disadavntages of synchronized
- synchronization degrades performance in java use it only when it's absolute necessary, prefer block synchronization rather than method level
- Doesn't allow concurrent read as well

##### How to achieve Thread Safety
There are four ways to achieve Thread Safety in Java. These are:

1. Synchronization
2. Volatile Keyword
3. Atomic Variable
4. Final Keyword
#### Atomic Variable
Using an atomic variable is another way to achieve thread-safety in java. When variables are shared by multiple threads, the atomic variable ensures that threads don’t crash into each other. 

`` 
class Counter {
 
    // Creating a variable of
    // class type AtomicInteger
    AtomicInteger count
        = new AtomicInteger();
 
    // Defining increment() method
    // to change value of
    // AtomicInteger variable
    public void increment()
    {
        count.incrementAndGet();
    }
}
``

