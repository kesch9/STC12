package ru.innopolis.lesson_6_online_thread.deadpool;

public class Main {
    public static void main(String[] args) {

        final  Object res1 = new Object();
        final  Object res2 = new Object();
        Thread1 thread1 = new Thread1(res1,res2);
        Thread2 thread2 = new Thread2(res1,res2);
        thread1.start();
        thread2.start();

    }
}
