package ru.innopolis.lesson_6_dz;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Monitor monitor = new Monitor();
        MessageThread messageThread1 = new MessageThread(1,monitor);
        MessageThread messageThread5 = new MessageThread(5,monitor);
        MessageThread messageThread7 = new MessageThread(7,monitor);
        SekundomeryThread sekundomeryThread = new SekundomeryThread(monitor);
        messageThread1.start();
        messageThread5.start();
        messageThread7.start();
        sekundomeryThread.start();


    }

}
