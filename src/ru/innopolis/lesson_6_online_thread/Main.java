package ru.innopolis.lesson_6_online_thread;

import ru.innopolis.lesson_6_online_thread.start.MyThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        MyThread myThread = new MyThread("Thread 1");
        MyThread myThread2 = new MyThread("Thread 2");
        MyThread myThread3 = new MyThread("Thread 3");
        MyThread myThread4 = new MyThread("Thread 4");

        myThread.start();
        myThread.join();
        myThread2.start();
        myThread2.join();
        myThread3.start();
        myThread3.join();
        myThread4.start();
        myThread4.join();

        System.out.println(System.currentTimeMillis() - startTime);

    }

}
