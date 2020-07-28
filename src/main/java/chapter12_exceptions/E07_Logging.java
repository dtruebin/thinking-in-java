/*
Modify Exercise 3 so that the catch clause logs the results.
 */

package main.java.chapter12_exceptions;

@SuppressWarnings({"MismatchedReadAndWriteOfArray", "ConstantConditions"})
public class E07_Logging {
    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            System.out.println(array[10]);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
