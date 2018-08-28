package ru.innopolis.lesson_5_onlinne_io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedExample {

    public static void main(String[] args) {
        String myString = "My String";
        try (FileOutputStream out = new FileOutputStream("/VirtualMachine/note.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)){
            byte[] buffer = myString.getBytes();
            bos.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
