package ru.innopolis.lesson_6_online_thread.deadpool;

public class Thread2 extends Thread{

    Object resource_1;
    Object resource_2;

    public Thread2(Object resource_1, Object resource_2) {
        this.resource_1 = resource_1;
        this.resource_2 = resource_2;
    }

    @Override
    public void run() {
        synchronized ((resource_2)){
            System.out.println("resouce 2 locked by thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resource_1){
                System.out.println("resouce 1 locked by thread 2");
            }
        }
    }
}
