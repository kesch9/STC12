package ru.innopolis.lesson_7_dz;

import ru.innopolis.lesson_3_dz.MathBox;
import ru.innopolis.lesson_4_dz.MyException;


import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws MyException {

        MathBoxInterface realMathBox = new MathBox(new Integer[]{1,2,3,5});
        MathBoxInterface mathBoxProxy = (MathBoxInterface) Proxy.newProxyInstance(MathBoxInvocationHandler.class.getClassLoader(),
                new Class[]{MathBoxInterface.class}, new MathBoxInvocationHandler(realMathBox));
        System.out.println(mathBoxProxy.summator());
    }

}
