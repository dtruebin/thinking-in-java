/*
Modify Exercise 16 so that you keep a count of the occurrence of each vowel.
 */

package main.java.chapter11_holding;

import java.util.*;

public class E20_SetVowelsEachVowelCount {
    private static final Set<Character> VOWELS_SET_LOWERCASE = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

    public static void main(String[] args) {
        String sentence = "This is some sentence containing some words that Olga might like.";

        Map<Character, Integer> countVowelsSentence = new HashMap<>();
        Set<String> processedWords = new HashSet<>();

        System.out.println("Counting vowels in each unique word:");
        for (String word : sentence.toLowerCase().split("\\W")) {
            Map<Character, Integer> countVowelsWord = countVowels(word);

            // Update sentence totals
            for (Character c : countVowelsWord.keySet()) {
                Integer countVowelsSentenceValue =
                        countVowelsSentence.get(c) == null ?
                                countVowelsWord.get(c) :
                                countVowelsSentence.get(c) + countVowelsWord.get(c);
                countVowelsSentence.put(c, countVowelsSentenceValue);
            }

            if (!processedWords.contains(word)) {
                processedWords.add(word);
                System.out.println(word + " - " + countVowelsWord);
            }
        }

        System.out.println("Total number of vowels is " + countVowelsSentence);
    }

    static Map<Character, Integer> countVowels(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (Character c : str.toCharArray()) {
            if (VOWELS_SET_LOWERCASE.contains(c)) {
                result.put(c, result.get(c) == null ? 1 : result.get(c) + 1);
            }
        }

        return result;
    }
}
