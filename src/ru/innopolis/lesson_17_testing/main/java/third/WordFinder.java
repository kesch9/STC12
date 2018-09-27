package ru.innopolis.lesson_17_testing.main.java.third;

import java.net.URL;
import java.util.HashSet;

public interface WordFinder {

    HashSet<String> getSenteces(URL source);
    boolean checkInWordSentence(String sentence, String word);
    public void writeSentenceToResult(String sentence);

}
