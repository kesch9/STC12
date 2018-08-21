package ru.innopolis.lesson_2_dz;

public class SomeClass {

    public static void main(String[] args) {

        MathBox mathBox = new MathBox();

//        Сложение
        System.out.println(mathBox.summa(2 ,3));
        System.out.println(mathBox.summa(2 ,-3));
        System.out.println(mathBox.summa(257436766 ,978578578));
//        Вычитание
        System.out.println(mathBox.diff(2 ,3));
        System.out.println(mathBox.diff(2 ,-3));
        System.out.println(mathBox.diff(257436766 ,978578578));
//        Факториал
//        System.out.println(mathBox.factorial(5));
//        Деление без exception
        System.out.println(mathBox.dividerExceptionInside(3,0));
        System.out.println(mathBox.dividerExceptionInside(2,64));
//        Деление с exception
        try {
            System.out.println(mathBox.divider(3,0));
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(mathBox.divider(2,1));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
