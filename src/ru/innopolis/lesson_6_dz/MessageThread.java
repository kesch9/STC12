package ru.innopolis.lesson_6_dz;

public class MessageThread extends Thread{
    private Long currentTime;
    private Integer currentStep;
    Monitor monitor;
    public Integer step;

    public MessageThread(Integer step, Monitor monitor) {
        currentStep = 0;
        currentTime = System.currentTimeMillis();
        this.step = step;
        this.monitor = monitor;
    }

    @Override
    public void run() {

        synchronized (monitor){
            while(monitor.getStep()<10) {
                //System.out.println("Run MessageThread " + Thread.currentThread().getName());
                if ((monitor.getStep() - currentStep) >= step) {
                    System.out.println("Прошло времени на Thread " + Thread.currentThread().getName()
                            + " " + (System.currentTimeMillis() - currentTime));
                    currentTime = System.currentTimeMillis();
                    currentStep = monitor.getStep();
                    monitor.notifyAll();
                }
                try {
                   // System.out.println("Run MessageThread wait " + Thread.currentThread().getName()+
                    //        "currentTimeAll= " + monitor.getStep());
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
