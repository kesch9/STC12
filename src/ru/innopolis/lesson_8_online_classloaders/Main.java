package ru.innopolis.lesson_8_online_classloaders;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

//        Some some = new Some("some");
//        ClassLoader classLoader = some.getClass().getClassLoader();
//        System.out.println(classLoader);
//
//        String someString = "Some";
//        ClassLoader classLoader2 = someString.getClass().getClassLoader();
//        System.out.println(classLoader2);

//        System.setSecurityManager(new SecurityManager());
//        SecurityManager securityManager = System.getSecurityManager();
//        System.out.println(securityManager);

        ClassLoader parentClassLoader = Magic.class.getClassLoader();
        Class magicClass = parentClassLoader.loadClass("ru.innopolis.lesson_8_online_classloaders.Magic");
        Magic magic = (Magic) magicClass.newInstance();
        magic.cast();
        KindMagicClassLoader kindMagicClassLoader = new KindMagicClassLoader(parentClassLoader);
        Class kindMagicClass = kindMagicClassLoader.loadClass("ru.innopolis.lesson_8_online_classloaders.Magic");
//        Magic magic1 = (Magic) kindMagicClass.newInstance();
//        magic1.cast();
        kindMagicClass.getMethod("cast").invoke(kindMagicClass.newInstance(),null);

    }
}
