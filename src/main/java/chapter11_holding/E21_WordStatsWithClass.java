/*
Modify the previous exercise so that it uses a class containing a String and
a count field to store each different word, and a Set of these objects to
maintain the list of words.

Additionally, try a TreeSet instead of a bare HashSet to maintain the list of
words, and compare what (if any) improvement this makes to the program.
 */

package main.java.chapter11_holding;

import java.util.*;

class Word implements Comparable<Word> {
    @SuppressWarnings("Convert2Lambda") // Not familiar with lambdas so far
    static final Comparator<Word> CASE_INSENSITIVE_ORDER = new Comparator<Word>() {
        @Override
        public int compare(Word o1, Word o2) {
            return o1.content.compareToIgnoreCase(o2.content);
        }
    };
    private final String content;
    private Integer count = 1;

    Word(String content) {
        this.content = content;
    }

    void incrementCount() {
        count++;
    }

    String getContent() {
        return content;
    }

    Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Word{" +
                "content='" + content + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public int compareTo(Word o) {
        return content.compareTo(o.content);
    }
}

public class E21_WordStatsWithClass {
    static Set<Word> createWordSetFromString(String input) {
        Set<Word> result = new TreeSet<>();

        for (String wordString : input.split("\\W+")) {
            Word word = new Word(wordString);

            for (Word existingWord : result) {
                if (word.equals(existingWord)) {
                    existingWord.incrementCount();
                }
            }

            // Working with a set, so no "if not contains" is necessary
            result.add(word);
        }

        return result;
    }

    public static void main(String[] args) {
        String input = E21_WordStats.input;

        Set<Word> wordSet = createWordSetFromString(input);

        List<Word> wordList = new ArrayList<>(wordSet);
        wordList.sort(Word.CASE_INSENSITIVE_ORDER);

        for (Word word : wordList) {
            System.out.println(word.getContent() + " -  " + word.getCount());
        }
    }
}