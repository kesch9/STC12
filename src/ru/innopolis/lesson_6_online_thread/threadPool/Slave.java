package ru.innopolis.lesson_6_online_thread.threadPool;

public class Slave {

    public Double count(){
        double sum = 0;
        for (int i =1; i<5000000; i++){
            sum += 10000/i;
        }
        return sum;
    }

}
