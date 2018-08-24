package ru.innopolis.lesson_3_online_collection;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap personList = new HashMap();

        personList.put(1, new PersonDto(1,"Sergej",40));
        personList.put(2, new PersonDto(2,"Ivan",20));
        personList.put(3, new PersonDto(3,"Petr",30));

        for (Object person: personList.values()){
            System.out.println(person);
        }



    }
}
