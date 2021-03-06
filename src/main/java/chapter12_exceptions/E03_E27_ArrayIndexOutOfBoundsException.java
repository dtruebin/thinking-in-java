/*
Exercise 3:
Write code to generate and catch an ArraylndexOutOfBoundsException.

Exercise 27:
Modify Exercise 3 to convert the exception to a RuntimeException.
 */

package chapter12_exceptions;

@SuppressWarnings({"MismatchedReadAndWriteOfArray", "ConstantConditions"})
public class E03_E27_ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
}
