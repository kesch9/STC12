package ru.innopolis.lesson_10_online_new_java.streams.create;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        Collection<String> strings = Arrays.asList("a1","b2","c3","a1","b3","c3");

//        List<String> distinct = syrings.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinct);

//        String[] array = strings.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
//        System.out.println(Arrays.asList(array));

//        String text = strings.stream().collect(Collectors.joining(":","<b>","</b>"));
//        System.out.println(text);

        Collection<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        long sumOdd = numbers.stream().collect(Collectors.summingInt((p) -> p%2 == 1?p:0));
        System.out.println(sumOdd);

        Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy((p) -> p%2 == 0));
        System.out.println(parts);

    }

}
