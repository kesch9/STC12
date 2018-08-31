package ru.innopolis.lesson_7_online_reflection.annot_proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Counter realCounter = new MathCounter();
        Counter counterProxy = (Counter) Proxy.newProxyInstance(CounterUnvocationHandler.class.getClassLoader(),
                new Class[]{Counter.class}, new CounterUnvocationHandler(realCounter));
        counterProxy.count();
    }
}