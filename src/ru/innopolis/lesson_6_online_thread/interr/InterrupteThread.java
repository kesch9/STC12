package ru.innopolis.lesson_6_online_thread.interr;

import java.util.Random;

public class InterrupteThread extends Thread{

    boolean inter;

//    public void setInter(boolean inter) {
//        this.inter = inter;
//    }

    @Override
    public void run() {
        do {
            long sum = 0;
            Random random = new Random(1000);
            for (int i = 0; i<100; i++){
                sum += random.nextInt();
            }
        } while (inter);
        System.out.println("Thread Stopped");
    }
}
