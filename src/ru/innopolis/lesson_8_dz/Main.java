package ru.innopolis.lesson_8_dz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String codeTest = new String("public class TestClass {\n" +
                "    void printSome(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "    }\n" +
                "}");
        ExecutorImplements executorImplements = new ExecutorImplements();
        executorImplements.execute(codeTest);
        ClassLoader parentClassLoader = Main.class.getClassLoader();
        System.out.println(parentClassLoader);
        Class testClass = parentClassLoader.loadClass("Main");
        Object test = testClass.newInstance();
        System.out.println(test.getClass());
    }
}
