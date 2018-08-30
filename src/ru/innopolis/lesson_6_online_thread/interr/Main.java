package ru.innopolis.lesson_6_online_thread.interr;

public class Main {
    public static void main(String[] args) {
        InterrupteThread thread = new InterrupteThread();
        thread.start();
        System.out.println("Thread started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("now try to stop");
        thread.interrupt();
    }
}
