/*
Create a Set of the vowels. Working from UniqueWords.java, count and display
the number of vowels in each input word, and also display the total number
of vowels in the input file.
 */

package chapter11_holding;

import java.util.Arrays;
import java.util.HashSet;

public class E16_SetVowels {
    private static final HashSet<Character> VOWELS_SET = new HashSet<>(
            Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'));

    public static void main(String[] args) {
        String sentence = "This is a sentence containing some words that Olga might like.";

        System.out.println("Counting vowels in each word:");
        for (String word : sentence.split("\\W")) {
            System.out.println(word + " - " + countVowels(word));
        }

        System.out.println("Total number of vowels is " + countVowels(sentence));
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
