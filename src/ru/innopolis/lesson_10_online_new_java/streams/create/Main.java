package ru.innopolis.lesson_10_online_new_java.streams.create;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("val1","val2","val3");
        System.out.println("Stream: " + stringStream.collect(Collectors.toList()));
        String[] array = {"val1","val2","val3"};
        Stream<String> stream = Arrays.stream(array);
        System.out.println("Stream: " + stream.collect(Collectors.toList()));
        File file = new File("1.tmp");
        file.deleteOnExit();
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("a1");
        out.println("a2");
        out.println("a3");
        out.println("a4");
        out.close();
        Stream<String> stream2 = null;
        try {
           stream2 = Files.lines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Stream: " + stream2.collect(Collectors.toList()));
    }

}
