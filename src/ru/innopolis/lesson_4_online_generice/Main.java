package ru.innopolis.lesson_4_online_generice;

import ru.innopolis.lesson_4_online_generice.doubleCode.GenericContainer;
import ru.innopolis.lesson_4_online_generice.doubleCode.IntegerContainer;

public class Main {

    public static void main(String[] args) {

        MathBox mathBox = new MathBox();
        mathBox.addDigit(12);
        mathBox.addDigit(43);
        System.out.println(mathBox.getSumm());

        IntegerContainer integerContainer = new IntegerContainer(12);
        System.out.println(integerContainer.getmInt());

        GenericContainer genericContainer = new GenericContainer(new Integer(23));
        genericContainer.setmGeneric("String");
        System.out.println(genericContainer.getmGeneric());

    }

}
