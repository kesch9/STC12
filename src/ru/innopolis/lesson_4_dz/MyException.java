package ru.innopolis.lesson_4_dz;

public class MyException extends Exception{

    @Override
    public String toString() {
        return "The collection is not only numbers";
    }

}
