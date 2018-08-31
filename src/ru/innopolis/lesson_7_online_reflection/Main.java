package ru.innopolis.lesson_7_online_reflection;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Capucin abu = new Capucin(50);
        Class<Capucin>clazz = (Class<Capucin>)abu.getClass();
        //ReflectionUtils.printClass(clazz);

        Capucin mrJenkins = new Capucin(10,100,30);
        Field footSizeField = mrJenkins.getClass().getDeclaredField("footSize");
        footSizeField.setAccessible(true);
        System.out.println(footSizeField.get(mrJenkins));
        footSizeField.set(mrJenkins,32);
        System.out.println(footSizeField.get(mrJenkins));
        Field tailLenghtField = mrJenkins.getClass().getDeclaredField("tailLenght");
        tailLenghtField.setAccessible(true);
        tailLenghtField.set(mrJenkins,1000);
        System.out.println(tailLenghtField.get(mrJenkins));
    }

}
