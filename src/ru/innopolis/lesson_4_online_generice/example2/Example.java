package ru.innopolis.lesson_4_online_generice.example2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example {


    public static void main(String[] args) {
        List<Line> l = new ArrayList<>();
        l.add(new Line());
        l.add(new Polygon());
        draw(l);
        List<Polygon> p = new ArrayList<>();
        //p.add(new Line());
        p.add(new Polygon());
        draw(p);
    }


    static void draw(List<? extends Line> lines){
        for (Iterator<? extends Line> i = lines.iterator(); i.hasNext();){
            Line s = i.next();
            s.draw();
        }
    }

}
