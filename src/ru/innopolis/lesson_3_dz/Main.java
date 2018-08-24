package ru.innopolis.lesson_3_dz;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int count = 100;
        Integer[] array = new Integer[count];
        for (int i = 0; i < count; i++){
            array[i] = random.nextInt(100);
        }
        MathBox mathBox = new MathBox(array);
        System.out.println(mathBox.summator());

        for ( Integer i : mathBox.splitter(2)){
            System.out.println(i);
        }

        System.out.println(mathBox.toString());

        System.out.println(mathBox.deleteElement(99));

        System.out.println(mathBox.toString());

        MathBox mathBox2 = new MathBox(array);

        System.out.println(mathBox.equals(mathBox2));
        System.out.println(mathBox.hashCode());
        System.out.println(mathBox.hashCode());




    }

}
