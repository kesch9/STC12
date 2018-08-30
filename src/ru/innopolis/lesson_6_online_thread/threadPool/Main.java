package ru.innopolis.lesson_6_online_thread.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newFixedThreadPool(20);
        Slave slave = new Slave();
        long start = System.currentTimeMillis();
        List<Future<Double>> futures = new ArrayList<>();
        for (int i=0; i < 400; i++){
            futures.add(CompletableFuture.supplyAsync(() ->slave.count(),threadpool));
        }

        double value = 0;
        for (Future<Double> future: futures){
            value += future.get();
        }

        System.out.println("Результиат " + value);

        System.out.println("Time " + (System.currentTimeMillis()-start));
        threadpool.shutdown();
    }
}
