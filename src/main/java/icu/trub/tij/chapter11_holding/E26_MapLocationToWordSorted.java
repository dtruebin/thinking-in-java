/*
Take the resulting Map from the previous exercise and re-create the order
of the words as they appeared in the original file.
 */

package icu.trub.tij.chapter11_holding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E26_MapLocationToWordSorted {
    public static void main(String[] args) {
        // Using string literal instead of reading from file, for simplicity
        String[] words = E21_WordStats.input.split("\\W+");

        Map<String, ArrayList<Integer>> map = new E25_MapWordsToLocations(words).getMap();

        System.out.println(convertWordLocationsMapIntoLocationWordMap(map));
    }

    static Map<Integer, String> convertWordLocationsMapIntoLocationWordMap(Map<String, ArrayList<Integer>> inMap) {
        Map<Integer, String> outMap = new HashMap<>();
        for (String word : inMap.keySet()) {
            List<Integer> locations = inMap.get(word);
            for (Integer location : locations) {
                outMap.put(location, word);
            }
        }
        return outMap;
    }
}
