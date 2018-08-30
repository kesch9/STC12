package ru.innopolis.lesson_6_online_thread.shop;

public class Store {
    private int products = 0;
    public synchronized void get(){
        while (products<1){
            System.out.println("wait for get");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println("Покупатель купил  1 товар");
        System.out.println("Товаров на складе " + products);
        notify();
    }

    public synchronized void put(){

        while (products>=5){
            System.out.println("wait for put");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        products++;
        System.out.println("Покупатель добавил  1 товар");
        System.out.println("Товаров на складе " + products);
        notify();
    }
}
