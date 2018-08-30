package ru.innopolis.lesson_6_online_thread.shop;

public class Producer implements Runnable {

    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i<20;i++){
            store.put();
        }
    }
}
