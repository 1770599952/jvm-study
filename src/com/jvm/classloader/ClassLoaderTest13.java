package com.jvm.classloader;

/**
 * Java虚拟机必须保证一个类的<clinit>方法在多线程环境中被正确地加锁同步，
 * 如果多个线程同时去初始化一个类，那么只会有其中一个线程去执行类的<cinit>方法，
 * 其他线程都需要阻塞等待，直到活动线程执行完毕<clinit>方法。
 *
 * 如果一个类的<clinit>有耗时很长的操作，那就可能造成多个进程阻塞。</></></></>
 */
public class ClassLoaderTest13 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };

        Thread initT1 = new Thread(runnable);
        Thread initT2 = new Thread(runnable);

        initT1.start();
        initT2.start();
    }
}

class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init ClassLoaderTest13");
            while (true) {
            }
        }
    }
}
