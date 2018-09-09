package ru.innopolis.lesson_10_online_new_java.threads;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is message from main");
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("message from Thread");

            }
        }).start();
    }

}
