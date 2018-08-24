package ru.innopolis.lesson_4_online_generice.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        dump(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(13);
        dump(list1);

    }

    static void dump(Collection<?> o){
        for (Iterator<?> i = o.iterator(); i.hasNext();){
            Object o1 = i.next();
            System.out.println(o1);
        }
    }

}
