package ru.innopolis.lesson_16_loggers.simple;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Simple {
    public static void main(String[] args) {
        System.err.println("Message to console");
        System.out.println("Usual message");
        try {
            System.setErr(new PrintStream(new FileOutputStream("errLog.log")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("Message to file");
    }
}
