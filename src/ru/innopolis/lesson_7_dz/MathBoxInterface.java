package ru.innopolis.lesson_7_dz;

import ru.innopolis.lesson_4_dz.MyException;

import java.util.Collection;

public interface MathBoxInterface {
    int summator() throws MyException;
    Collection<Integer> splitter(int div) throws MyException;
    boolean deleteElement(Integer i)throws MyException;
}
