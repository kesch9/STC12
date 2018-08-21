package ru.innopolis.lesson_2_dz;

public class MathBox {


    public int summa (Integer a, Integer b){
        return a+b;
    }

    public int diff (Integer a, Integer b){
        return a-b;
    }

    public long factorial (Integer a){
        if (a == 0) return 1;

//        Правильное решение
//        return a * factorial(a-1);

//        StackOverflowError
        return a * factorial(a);

    }

    public double dividerExceptionInside(Integer a, Integer b){
        if (b == 0){
            return 0;
        }
        return (float)a/(float)b;
    }

    public double divider (Integer a, Integer b) throws MyException {
//        Проброс Ошибки арифметической
        if (b == 1){
           throw new ArithmeticException();
        }

//      Свой Exception
        if (b == 0){
           throw new MyException();
        }

        return (float)a/(float)b;
    }

}
