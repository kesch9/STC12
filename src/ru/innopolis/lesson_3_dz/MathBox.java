package ru.innopolis.lesson_3_dz;

import ru.innopolis.lesson_4_dz.MyException;
import ru.innopolis.lesson_7_dz.ClearData;
import ru.innopolis.lesson_7_dz.Logged;
import ru.innopolis.lesson_7_dz.MathBoxInterface;

import java.util.*;

public class MathBox implements MathBoxInterface {

    private TreeSet<Integer> set;

    protected TreeSet<Integer> getSet() {
        return set;
    }

    public MathBox(Integer[] inputArray) {
        ArrayList<Integer> numbersArrayList = new ArrayList(Arrays.asList(inputArray));
        set = new TreeSet<>(numbersArrayList);
    }
    @Logged
    @ClearData
    public int summator() throws MyException {
        int sum = 0;
        for (Integer i: set){
             sum += i;
        }
        return sum;
    }
    @Logged
    @ClearData
    public Collection <Integer> splitter(int div) throws MyException {

        ArrayList list = new ArrayList();
        for (Integer i : set){
            list.add(i/div);
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(set, mathBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("Содержимое класса MathBox: [");
        for (Integer i: set){
            stringBuilder.append(i + ", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    @Logged
    @ClearData
    public boolean deleteElement(Integer i) throws MyException {
        return set.remove(i);
    }


}
