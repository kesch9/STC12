package ru.innopolis.lesson_5_onlinne_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {
        try(FileInputStream fio = new FileInputStream("/VirtualMachine/test.txt");
        FileOutputStream foe = new FileOutputStream("/VirtualMachine/test_new.txt")){
            byte[] buffet = new byte[fio.available()];
            fio.read(buffet, 0, buffet.length);
            foe.write(buffet,0,buffet.length);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}

