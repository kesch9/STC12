package ru.innopolis.lesson_7_online_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    private ReflectionUtils(){

    }

    public static void printClass(Class clazz){
        printFields(clazz);
        System.out.println();
        printDeclaredFields(clazz);
        System.out.println();
        printMethods(clazz);
        System.out.println();

    }

    private static void printMethods(Class clazz) {
        System.out.println("Class " + clazz.getName() + " getMethods ");
        methodIterator(clazz.getMethods());
    }

    private static void printFields(Class clazz){
        System.out.println("Class " + clazz.getName() + " getFields ");
        fieldIterator(clazz.getFields());
    }

    private static void printDeclaredFields(Class clazz){
        System.out.println("Class " + clazz.getName() + " getDeclaredFields ");
        fieldIterator(clazz.getDeclaredFields());
    }

    private static void fieldIterator(Field[] fields){
        for(Field field:fields){
            System.out.println("name " + field.getName() + " type - " + field.getType().getCanonicalName());
            System.out.println("modifier " + field.getModifiers());
        }
    }

    private static  void methodIterator(Method[] methods){
        for (Method method:methods){
            System.out.println("Name " + method.getName());
            System.out.println("return type " + method.getReturnType().getName());
            System.out.println("Parametrs: ");
            for (Class parameterClass: method.getParameterTypes()){
                System.out.println( parameterClass.getName() + " ,");
            }
        }
    }

}
