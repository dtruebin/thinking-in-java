/*
Create a Map<String,ArrayList<Integer>>. Use net.mindview.TextFile to open
a text file and read it in a word at a time (use "\\W+" as the second argument
to the TextFile constructor). Count the words as you read them in, and for each
word in the file, record in the ArrayList<Integer> the word count associated
with that word - this is, in effect, the location in the file where that word
was found.
*/

package chapter11_holding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E25_MapWordsToLocations {
    public static void main(String[] args) {
        // Using string literal instead of reading from file, for simplicity
        String[] words = E21_WordStats.input.split("\\W+");

        Map<String, ArrayList<Integer>> wordToLocationsMap = new HashMap<>();
        int wordCount = 0;
        for (String word : words) {
            ArrayList<Integer> wordLocations = wordToLocationsMap.get(word);
            //noinspection Java8MapApi (not yet familiar with lambdas)
            if (wordLocations == null) {
                wordLocations = new ArrayList<>();
                wordToLocationsMap.put(word, wordLocations);
            }
            wordLocations.add(++wordCount);
        }

        System.out.println(wordToLocationsMap);
    }
}