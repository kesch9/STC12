package ru.innopolis.lesson_4_online_generice;

import java.util.ArrayList;
import java.util.List;

public class MathBox {

    private List<Integer> digits = new ArrayList();


    public void addDigit(Integer digit){
        digits.add(digit);
    }

    public Integer getSumm(){
        Integer sum = 0;
        for (Object digit:digits){
            sum+=(Integer)digit;
        }
        return sum;
    }

}
