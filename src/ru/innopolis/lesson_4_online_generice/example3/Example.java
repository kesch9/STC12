package ru.innopolis.lesson_4_online_generice.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Example {

    public static void main(String[] args) {
        addAll(new ArrayList<Integer>(), new ArrayList<Integer>());
        addAll(new ArrayList<String>(), new ArrayList<Object>());
    }

    static <M,N extends M> void addAll(Collection<N> c, Collection<M> c2){
        for(Iterator<N> i = c.iterator(); i.hasNext();){
            M o = i.next();
            c2.add(o);
        }
    }

}
