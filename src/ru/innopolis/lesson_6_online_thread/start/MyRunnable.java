package ru.innopolis.lesson_6_online_thread.start;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int iteration = 5000000;
        double sum = 0;
        for (int i = 1; i < iteration; i++){
            sum += 10000/i;
        }
        System.out.println(sum);
    }

}
