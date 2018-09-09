package ru.innopolis.lesson_10_online_new_java.cycle;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,5,6,7);

        for (int number : list){
            System.out.println(number);
        }

        list.forEach(System.out::println);

    }

}
