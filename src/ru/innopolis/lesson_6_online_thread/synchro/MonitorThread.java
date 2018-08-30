package ru.innopolis.lesson_6_online_thread.synchro;

public class MonitorThread extends Thread{

    Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        synchronized (monitor) {
            System.out.println(Thread.currentThread().getName() + " locked monitor");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " monitor free");
        }
    }
}
