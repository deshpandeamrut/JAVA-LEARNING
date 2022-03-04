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
2. No Preemption - No forceful snatching of resources
3. Circular Wait - A set of threads are waiting for resource in circular order 
    ex; t1 with R2 -> R1 , t2   with R1 -> R2
4. Mutual Exclusion - There is one set of resource and is non-sharable

## Thread pool
It is a group of threads created to execute a set of tasks. It helps in reducing the time needed to create new threads and hence making the application more responsive

Executor framework helps in acheiving this in Java.
We need to create a set of tasks and create a thread pool with some number and ask the executor service to execute them.