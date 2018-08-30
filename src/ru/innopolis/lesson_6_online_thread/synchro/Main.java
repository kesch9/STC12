package ru.innopolis.lesson_6_online_thread.synchro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            MonitorThread thread = new MonitorThread();
            thread.setMonitor(monitor);
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread: threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Finished");

    }
}
