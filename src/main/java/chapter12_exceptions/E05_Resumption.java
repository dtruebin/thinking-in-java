/*
Create your own resumption-like behavior using a while loop that repeats until
an exception is no longer thrown.
 */

package main.java.chapter12_exceptions;

import java.util.Random;

public class E05_Resumption {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[rand.nextInt(10)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }

        /*
        Get the last element in the array, approaching it from "some distance
        from the right"
         */
        int index = array.length + rand.nextInt(10);
        while (true) {
            try {
                System.out.println("Element at index " + index + " = " + array[index]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                index--;
            }
        }
    }
}
