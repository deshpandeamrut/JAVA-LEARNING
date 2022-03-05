# JAVA Threads

## Process vs Thread

### Process 
- Is heavy, & resource rich. 
- Each process has its own address space.
- Context switching is difficult and inter process communication is costly

### Thread
- Thread is a light weight process
- Multiple threads can share the same address space
- Hence the context switching is also easy
- Inter-thread communication is also easy


###Concurrency vs Parallelism
Concurrency means multiple tasks which start, run, and complete in overlapping time periods, in no specific order. Parallelism is when multiple tasks OR several part of a unique task literally run at the same time, e.g. on a multi-core processor.

**Deadlock** - It is a situation in which two or more threads are indefinitely waiting(blocked) to acquire each other’s resources

**Livelock** - In the case of a livelock, the states of the processes involved in a live lock scenario constantly change. On the other hand, the processes still depend on each other and can never finish their tasks.

**Starvation** is an outcome of a process that is unable to gain regular access to the shared resources it requires to complete a task and thus, unable to make any progress.

There are two ways to create a thread:

 - Extending Thread class
 - Implementing Runnable interface

##### Difference in both the approaches

- Creating by implementing runnable is preferred way
- Instantiating an interface gives a cleaner separation between your code and the implementation of threads.
- Runnable instance helps in reusing the thread
- Java only supports single inheritance, so you can only extend one class.

![alt text](https://github.com/deshpandeamrut/JAVA-LEARNING/blob/main/src/main/resources/Java_-_Wait_and_Notify.webp) 

## Dameon vs User Threads
Daemon threads are low priority threads which always run in background and user threads are high priority threads which always run in foreground. User Thread or Non-Daemon are designed to do specific or complex task where as daemon threads are used to perform supporting tasks.
 - JVM will not force the user threads to terminate. It will wait for user threads to terminate themselves. On the other hand, JVM will force the daemon threads to terminate if all the user threads have finished their task.
 - Daemon threads can be created by setting setDaemon flag to true on Thread object
 - Thread created by the user ex: main program
 - JVM waits till user thread is terminated properly
 - User thread can be made to Daemon by setting setDaemon() as true

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

#### sleep()
- Available in java.lang.Thread
- Tells the current thread to sleep for certain time period
- Accepts in milliseconds
- Throws exceptions
- No guarantee
- Once sleep is complete , thread may be in runnable or running state
- Does not release resources

#### Yield() (static method Thread.yield())
- Tells the current thread to give chance to the thread with equal priority in the thread pool
- Yield can only make a thread to go to runnable state and its not guaranteed

#### join()
- Not static has to be called with thread objects
- It tells the current running thread to wait until the task of join calling thread is over
- I.e if t1 is running and t2.join() is called in between, t1 has to wait until t2 completes
- It is guaranteed that the thread will wait 

#### Deprecated Methods()
- stop()
- suspend()
- destroy()
- resume()

#### Instead use 
- Sleep
- Interrupt:used to interrupt if thread is sleeping


### wait()
- calling wait() forces the current thread to wait until some other thread invokes notify() or notifyAll() on the same object.
- It also release the resources the thread is currently having
- when we've executed synchronized instance method for the given object
- when we've executed the body of a synchronized block on the given object
	by executing synchronized static methods for objects of type Class

### notify()
For all threads waiting on this object's monitor (by using any one of the wait() methods), the method notify() notifies any one of them to wake up arbitrarily. 

### notifyAll()
This method simply wakes all threads that are waiting on this object's monitor.

The awakened threads will complete in the usual manner, like any other thread.

#### Fake Wakeups or Spurious Wakeups
A thread can also wake up without being notified, interrupted, or
>> timing out, a so-called <i>spurious wakeup</i>.  While this will rarely
>> occur in practice, applications must guard against it by testing for
>> the condition that should have caused the thread to be awakened and
>> continuing to wait if the condition is not satisfied.  In other words,
>> waits should always occur in loops, like this one: 
>>     synchronized (obj) {
>>         while (condition does not hold)
>>            obj.wait(timeout);
>>         ... // Perform action appropriate to condition
>>     }

### Lock Fairness
We'll briefly touch on the topic of fairness in locks since its out of scope for this course. When locks get acquired by threads, there's no guarantee of the order in which threads are granted access to a lock. A thread requesting lock access more frequently may be able to acquire the lock unfairly greater number of times than other locks. Java locks can be turned into fair locks by passing in the fair constructor parameter. However, fair locks exhibit lower throughput and are slower compared to their unfair counterparts.

### Java Concurrent APIs
1. ExecutorService
ExecutorService interface is basically a sub-interface of Executor interface with some additional methods or features that help in managing and controlling the execution of threads. It enables us to execute tasks asynchronously on threads.
Java offers thread pools via its Executor Framework. The framework includes classes such as the ThreadPoolExecutor for creating thread pools

2. ReentrantLock
ReentrantLock provides the same visibility and orderings guaranteed as implicit lock, acquired by synchronized keyword in Java, it provides more functionality and differs in certain aspects. As stated earlier,  the main difference between synchronized and ReentrantLock is the ability to try to lock interruptibly, and with timeout. Thread doesn’t need to block infinitely, which was the case with synchronized. 

    1. Ability to lock interruptibly.
    2. Ability to timeout while waiting for lock.
    3. Power to create a fair lock.
    4. API to get a list of waiting threads for lock.
    5. Flexibility to try to lock without blocking.

3. CountdownLatch
CountDownLatch is used to make sure that a task waits for other threads before it starts. To understand its application, let us consider a server where the main task can only start when all the required services have started.
Working of CountDownLatch:
When we create an object of CountDownLatch, we specify the number of threads it should wait for, all such thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. As soon as count reaches zero, the waiting task starts running.
https://www.geeksforgeeks.org/countdownlatch-in-java/

4. Cyclic Barrier 
	Same as countdownlatch except here, we can reset the latch to make wait again


#### HashTable vs Concurrent HashMap
Both are thread safe map implementations
Hashtable locks the entire map where as concurrentHashMap locks only certain areas of map so that others are free to access
Concurrenthashmap is hence more performant

### Producer Consumer Problem
In order to have consistent data synchronization the following conditions have to be met
1. The producer should not produce data when the buffer/list/queue is full
2. The consumer should not try to consume when the buffer is empty
3. The buffer/queue/list should be accesses either by producer or consumer at a time




