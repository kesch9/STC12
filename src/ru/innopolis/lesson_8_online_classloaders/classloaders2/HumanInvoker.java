package ru.innopolis.lesson_8_online_classloaders.classloaders2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanInvoker implements InvocationHandler {

    public HumanInvoker() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanLoader humanLoader = new HumanLoader(proxy.getClass().getClassLoader());
        Class humanClass = humanLoader.loadClass("ru.innopolis.lesson_8_online_classloaders.classloaders2.EuropeanHuman");
        Method newMethod = humanClass.getMethod(method.getName());
        return newMethod.invoke(humanClass.newInstance(),args);

    }
}
