package ru.innopolis.lesson_7_online_reflection.first_proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Trainer trainer = new JavaTraner();
        TrainerCenter trainerCenter = new TrainerCenter(trainer);
        Trainer stc = (Trainer) Proxy.newProxyInstance(TrainerCenter.class.getClassLoader(),
                new Class[]{Trainer.class}, trainerCenter);
        System.out.println("WithoutProxy");
        trainer.talk();
        System.out.println("Proxe");
        stc.talk();
    }

}
