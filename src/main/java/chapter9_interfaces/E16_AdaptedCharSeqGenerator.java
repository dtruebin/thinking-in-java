package chapter9_interfaces;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class CharSequence {
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private static final Random rand = new Random(47);

    char[] generate() {
        char[] result = new char[10];

        int index = 0;

        result[index++] = capitals[rand.nextInt(capitals.length)];
        for (int i = 0; i < 4; i++) {
            result[index++] = vowels[rand.nextInt(vowels.length)];
            result[index++] = lowers[rand.nextInt(lowers.length)];
        }

        result[index] = ' ';

        return result;
    }
}

class AdaptedCharSequence extends CharSequence implements Readable {

    private int count;

    public AdaptedCharSequence(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }

        char[] buffer = generate();
        cb.put(buffer);
        return buffer.length;
    }
}

public class E16_AdaptedCharSeqGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new AdaptedCharSequence(10));
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
