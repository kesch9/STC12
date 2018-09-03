package ru.innopolis.lesson_7_dz;

import ru.innopolis.lesson_4_dz.MyException;

import java.util.Collection;
import java.util.TreeSet;

public interface MathBoxInterface {
    TreeSet<Integer> set = null;
    @Logged
    @ClearData
    int summator() throws MyException;
    @Logged
    @ClearData
    Collection<Integer> splitter(int div) throws MyException;
    @Logged
    @ClearData
    boolean deleteElement(Integer i)throws MyException;
}
