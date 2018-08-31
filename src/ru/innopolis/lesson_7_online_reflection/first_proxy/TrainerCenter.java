package ru.innopolis.lesson_7_online_reflection.first_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainerCenter implements InvocationHandler {

    private Trainer trainer;

    public TrainerCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I take your money");
        System.out.println("I give money to trainer and consultans");
        System.out.println("Letd go studying");
        if(method.getName().equals("talk")){
            System.out.println("Many talk");
        }
        return method.invoke(trainer,args);
    }
}
