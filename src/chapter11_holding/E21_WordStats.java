package chapter11_holding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E21_WordStats {
    static String input = "Using a Map<String,Integer>, follow the form of "
            + "UniqueWords.java to create a program that counts the "
            + "occurrence of words in a file. Sort the results using "
            + "Collections.sort() with a second argument of "
            + "String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort)"
            + ", and display the result.";

    public static void main(String[] args) {

        Map<String, Integer> wordStats = new HashMap<>();

        for (String word : input.split("\\W+")) {
            Integer freq = wordStats.get(word);
            wordStats.put(word, freq == null ? 1 : freq + 1);
        }

        List<String> uniqueWords = new ArrayList<>(wordStats.keySet());
        uniqueWords.sort(String.CASE_INSENSITIVE_ORDER);

        for (String word : uniqueWords) {
            System.out.println(word + " -  " + wordStats.get(word));
        }
    }
}