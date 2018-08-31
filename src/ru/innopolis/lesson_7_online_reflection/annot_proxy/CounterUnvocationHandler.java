package ru.innopolis.lesson_7_online_reflection.annot_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CounterUnvocationHandler implements InvocationHandler {

    private Counter counter;

    public CounterUnvocationHandler(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = counter.getClass();
        if (counter.getClass().getAnnotation(Logged.class) != null) {
            long startTime = System.currentTimeMillis();
            System.out.println("We call method " + method.getName());
            Object result = method.invoke(counter, args);
            System.out.println(" with time " + (System.currentTimeMillis() - startTime));
            return result;
        } else {
            return method.invoke(counter, args);
        }
    }
}