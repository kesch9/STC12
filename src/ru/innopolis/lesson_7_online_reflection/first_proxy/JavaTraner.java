package ru.innopolis.lesson_7_online_reflection.first_proxy;

public class JavaTraner implements Trainer {
    @Override
    public void teach() {
        System.out.println("Java is so complicated");
    }

    @Override
    public void eat() {
        System.out.println("I like to eat mango");
    }

    @Override
    public void talk() {
        System.out.println("Where your homework");
    }
}
