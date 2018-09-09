package ru.innopolis.lesson_10_online_new_java.threads;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("This is message from main");
        new Thread(()-> System.out.println("message from Thread")).start();
    }
}
