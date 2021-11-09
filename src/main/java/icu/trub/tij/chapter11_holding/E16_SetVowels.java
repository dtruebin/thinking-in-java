/*
Create a Set of the vowels. Working from UniqueWords.java, count and display
the number of vowels in each input word, and also display the total number
of vowels in the input file.
 */

package icu.trub.tij.chapter11_holding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E16_SetVowels {
    private static final Set<Character> VOWELS_SET = new HashSet<>(
            Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'));

    public static void main(String[] args) {
        String sentence = "This is some sentence containing some words that Olga might like.";

        int countVowelsSentence = 0;
        Set<String> processedWords = new HashSet<>();

        System.out.println("Counting vowels in each unique word:");
        for (String word : sentence.toLowerCase().split("\\W")) {
            int countVowelsWord = countVowels(word);
            countVowelsSentence += countVowelsWord;

            if (!processedWords.contains(word)) {
                processedWords.add(word);
                System.out.println(word + " - " + countVowelsWord);
            }
        }

        System.out.println("Total number of vowels is " + countVowelsSentence);
    }

    static int countVowels(String str) {
        int count = 0;

        for (Character c : str.toCharArray()) {
            if (VOWELS_SET.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
