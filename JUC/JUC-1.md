## Semaphore

控制并发线程数码

主要方法：

* Semaphore(int permits)  构造方法，并设置许可数
* `Semaphore(int permits, boolean fair)`  公平性
* acquire（）   线程可中断，可加参数指定获取的许可数，默认1，为零时造成阻塞
* release（）  同上，释放许可数
* availablePermits   当前的可用的许可数
* acquireUninterruptibly  线程不可中断，其他和acquire一样
* drainPermits   返回当前的可用的许可数，并置为零
* getQueueLength()   取得等待许可的线程数
* hasQueuedThreads()  判断是否有线程等待许可
* `tryAcquire()`  尝试获取1个许可数，无阻塞
* `tryAcquire(int permits)` 尝试获取多个许可数，无阻塞
* `tryAcquire(int permits, long timeout, TimeUnit unit)`   设置等待时间，获取不到返回false



```java
package Project1_Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2018/12/11.
 */
public class semaphoreTest {
    public static void main(String[] args){
        Semaphore sem=new Semaphore(10);
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sem.acquire(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" is runing\n"+sem.availablePermits());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sem.release(2);
                    System.out.println(Thread.currentThread().getName()+" release\n"+sem.availablePermits());
                }
            }).start();
        }
    }
}

```

下面是输出

> Thread-0 is runing
> 8
> Thread-1 is runing
> 6
> Thread-2 is runing
> 4
> Thread-3 is runing
> 2
> Thread-4 is runing
> 0
> Thread-0 release
> 2
> Thread-1 release
> 0
> Thread-5 is runing
> 2
> Thread-6 is runing
> 0
> Thread-7 is runing
> 0
> Thread-2 release
> 2
> Thread-8 is runing
> 0
> Thread-3 release
> 0
> Thread-4 release
> 0
> Thread-9 is runing
> 0
> Thread-5 release
> 4
> Thread-11 is runing
> 0
> Thread-10 is runing
> 0
> Thread-6 release
> 4
> Thread-12 is runing
> 0
> Thread-8 release
> 0
> Thread-13 is runing
> 0
> Thread-9 release
> 0
> Thread-14 is runing
> 0
> Thread-7 release
> 0
> Thread-11 release
> 0
> Thread-15 is runing
> 0
> Thread-16 is runing
> 0
> Thread-10 release
> 2
> Thread-17 is runing
> 0
> Thread-13 release
> 4
> Thread-19 is runing
> 0
> Thread-18 is runing
> 0
> Thread-12 release
> 0
> Thread-14 release
> 0
> Thread-15 release
> 2
> Thread-16 release
> 4
> Thread-17 release
> 6
> Thread-19 release
> 8
> Thread-18 release
> 10
>
> Process finished with exit code 0

可以看到确实造成阻塞，总的线程为5个

### 多进路-多处理-多出路

简单思路是让多个线程共享一个Semaphore

每个线程处理自己的任务

```
Run代码
package Project1_Semaphore.MoreToOne_1;

public class Run {
    public static void main(String[] args){
        Service1 service1 = new Service1();
        MyThread[] threadsArray = new MyThread[12];
        for(int i=0;i<threadsArray.length;i++){
            threadsArray[i] = new MyThread(service1);
            threadsArray[i].start();
        }
    }
}

MyThread代码
package Project1_Semaphore.MoreToOne_1;

public class MyThread extends Thread {
    private Service1 service ;

    public MyThread(Service1 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.sayHello();
    }
}

service代码
package Project1_Semaphore.MoreToOne_1;

import java.util.concurrent.Semaphore;

/**
 * 多进路-多处理-多出路实验
 */
public class Service1 {
    private  Semaphore semaphore = new Semaphore(3);

    public void sayHello(){
        try {
            semaphore.acquire();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "准备");
            System.out.println("start hello || Time="+System.currentTimeMillis());
            for(int i=0;i<4;i++) {
                System.out.println(Thread.currentThread().getName() + "打印:" + i);
            }
            System.out.println("end hello ||  Time="+System.currentTimeMillis());
            semaphore.release();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```





### 多进路-单处理-多出路

ReentrantLock设置临界区，保证同步

```
package Project1_Semaphore.MoreToOne_2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多进路-单处理-多出路实验
 */
public class Service1 {
    private  Semaphore semaphore = new Semaphore(3);
    private ReentrantLock lcok = new ReentrantLock();
    public void sayHello(){
        try {
            semaphore.acquire();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "准备");
            lcok.lock();
            System.out.println("end hello || Time="+System.currentTimeMillis());
            for(int i=0;i<4;i++) {
                System.out.println(Thread.currentThread().getName() + "打印:" + i);
            }
            System.out.println("end hello ||  Time="+System.currentTimeMillis());
            lcok.unlock();
            semaphore.release();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```



## Exchanger

### 基本方法

* `exchange(V x)`  等待直到另一个线程与他交换数据或被中断
* `exchange(V x, long timeout, TimeUnit unit)` 设置等待时间

## CountDownLatch

判断count不为零时所有线程均等待，使得线程得以一起执行

只能使用一次

### 基本方法

* `CountDownLatch(int count)`  count  初始容量
* `await()`    让现在的现场等待，直到count=0
* `await(long timeout, TimeUnit unit)`  
* `countDown()`   count--
* `getCount()`  return count

```java
class Driver { // ...
   void main() throws InterruptedException {
     CountDownLatch startSignal = new CountDownLatch(1);
     CountDownLatch doneSignal = new CountDownLatch(N);

     for (int i = 0; i < N; ++i) // create and start threads
       new Thread(new Worker(startSignal, doneSignal)).start();

     doSomethingElse();            // don't let run yet
     startSignal.countDown();      // let all threads proceed
     doSomethingElse();
     doneSignal.await();           // wait for all to finish
   }
 }

 class Worker implements Runnable {
   private final CountDownLatch startSignal;
   private final CountDownLatch doneSignal;
   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
     this.startSignal = startSignal;
     this.doneSignal = doneSignal;
   }
   public void run() {
     try {
       startSignal.await();
       doWork();
       doneSignal.countDown();
     } catch (InterruptedException ex) {} // return;
   }

   void doWork() { ... }
 }
```

Example

```java
package Project2_CountDownLatchAndCyclicBarrier;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/12/11.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(20);
        System.out.println("开始");
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is start");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    latch.countDown();

                    System.out.println(Thread.currentThread().getName()+" is end");
                }
            }).start();
        }
        latch.await();
        Thread.sleep(200);
        System.out.println("结束");
    }
}
```



结果

> "C:\Program Files (x86)\Java\jdk1.8.0_181\bin\java" -Didea.launcher.port=7532 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\charsets.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\deploy.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\access-bridge-32.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\dnsns.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\jaccess.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\localedata.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\nashorn.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\sunec.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\zipfs.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\javaws.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\jce.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\jfr.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\jfxswt.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\jsse.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\management-agent.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\plugin.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\resources.jar;C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\rt.jar;C:\Users\Administrator.PC-201807161523\eclipse-workspace\JUCExample\out\production\JUCExample;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0.2\lib\junit-4.12.jar;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0.2\lib\hamcrest-core-1.3.jar;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0.2\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain Project2_CountDownLatchAndCyclicBarrier.CountDownLatchTest
> 开始
> Thread-0 is start
> Thread-1 is start
> Thread-2 is start
> Thread-3 is start
> Thread-4 is start
> Thread-5 is start
> Thread-6 is start
> Thread-7 is start
> Thread-8 is start
> Thread-9 is start
> Thread-10 is start
> Thread-11 is start
> Thread-12 is start
> Thread-14 is start
> Thread-13 is start
> Thread-15 is start
> Thread-16 is start
> Thread-17 is start
> Thread-18 is start
> Thread-19 is start
> Thread-1 is end
> Thread-2 is end
> Thread-0 is end
> Thread-4 is end
> Thread-3 is end
> Thread-5 is end
> Thread-6 is end
> Thread-7 is end
> Thread-11 is end
> Thread-8 is end
> Thread-10 is end
> Thread-9 is end
> Thread-12 is end
> Thread-19 is end
> Thread-18 is end
> Thread-17 is end
> Thread-15 is end
> Thread-16 is end
> Thread-13 is end
> Thread-14 is end
> 结束
>
> Process finished with exit code 0



## CyclicBarrier

可重用的CountDownLatch

## 基本方法

* `CyclicBarrier(int parties)` 同上
* `CyclicBarrier(int parties, Runnable barrierAction)` 所有线程完成后，再执行barrierAction
* `await()`  所有线程都执行后才往下执行
* `await(long timeout, TimeUnit unit)` 设置等待时间
* `getNumberWaiting()` 
* `getParties()` 
* `reset()` CyclicBarrier回到初始状态，重置
* isBroken  查询屏障是否处于损坏状态



```
 class Solver {
   final int N;
   final float[][] data;
   final CyclicBarrier barrier;

   class Worker implements Runnable {
     int myRow;
     Worker(int row) { myRow = row; }
     public void run() {
       while (!done()) {
         processRow(myRow);

         try {
           barrier.await();
         } catch (InterruptedException ex) {
           return;
         } catch (BrokenBarrierException ex) {
           return;
         }
       }
     }
   }

   public Solver(float[][] matrix) {
     data = matrix;
     N = matrix.length;
     Runnable barrierAction =
       new Runnable() { public void run() { mergeRows(...); }};
     barrier = new CyclicBarrier(N, barrierAction);

     List<Thread> threads = new ArrayList<Thread>(N);
     for (int i = 0; i < N; i++) {
       Thread thread = new Thread(new Worker(i));
       threads.add(thread);
       thread.start();
     }

     // wait until done
     for (Thread thread : threads)
       thread.join();
   }
 }
```

```
public class CyclicBarrierTest {
    public static void main(String[] args)throws Exception{
        CyclicBarrier cyclic=new CyclicBarrier(20);
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始工作\n"+cyclic.getNumberWaiting());
                    System.out.println(Thread.currentThread().getName()+"结束工作，开始等待开门");
                    try {
                        cyclic.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"出来了");
                }
            }).start();
        }
    }
}
```

