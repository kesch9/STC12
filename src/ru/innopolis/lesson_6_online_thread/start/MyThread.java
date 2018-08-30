package ru.innopolis.lesson_6_online_thread.start;

public class MyThread extends Thread {

    String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run(int iterations) {
        int iteration = 5000000;
        double sum = 0;
        for (int i = 0; i < iteration; i++){
            sum += 10000/i;
        }
        System.out.println(sum);
    }


}
