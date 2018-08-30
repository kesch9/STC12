/*Напишите программу, один поток которой каждую секунду отображает на экране данные о времени,
        прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
        Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
        потоком, отсчитывающим время. Отсчитывать время (использовать sleep) может только один поток
        Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на

        экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(),
        notifyAll() по какому-то монитору, общему для всех потоков.

        Бонус: Пакет Concurrent, перевод примеров на Lock  вместо синхронизации через wait-notify
*/

package ru.innopolis.lesson_6_dz;

public class SekundomeryThread extends Thread{

    public Monitor monitor;

    public SekundomeryThread(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        //System.out.println("Run SekundomeryThread " + Thread.currentThread().getName());

            while (monitor.getStep()<10) {
                synchronized (monitor) {
                    monitor.setStep(monitor.getStep() + 1);
                   System.out.println("Текущий степ " + monitor.getStep());
                    monitor.notifyAll();
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


}
