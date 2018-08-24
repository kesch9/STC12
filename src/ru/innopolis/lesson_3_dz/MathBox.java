package ru.innopolis.lesson_3_dz;

import java.util.*;

public class MathBox {

    private HashSet<Integer> set;

    public MathBox(Integer[] inputArray) {
        ArrayList<Integer> integerArrayList = new ArrayList(Arrays.asList(inputArray));
        Collections.sort(integerArrayList);
        set = new HashSet<>(integerArrayList);
    }

    public int summator() {
        int sum = 0;
        for (int i: set){
            sum += i;
        }
        return sum;
    }

    public Collection <Integer> splitter(int div){

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
        for (int i: set){
            stringBuilder.append(i + ", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean deleteElement(Integer i){
        return set.remove(i);
    }


}
