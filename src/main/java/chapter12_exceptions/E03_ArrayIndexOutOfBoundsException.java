/*
Write code to generate and catch an ArraylndexOutOfBoundsException.
 */

package main.java.chapter12_exceptions;

@SuppressWarnings({"MismatchedReadAndWriteOfArray", "ConstantConditions"})
public class E03_ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            System.out.println(array[10]);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
