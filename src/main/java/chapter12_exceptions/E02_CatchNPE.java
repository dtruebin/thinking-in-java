/*
Define an object reference and initialize it to null. Try to call a method
through this reference. Now wrap the code in a try-catch clause to catch the
exception.
 */

package main.java.chapter12_exceptions;

public class E02_CatchNPE {
    public static void main(String[] args) {
        Object o = null;

        try {
            //noinspection ResultOfMethodCallIgnored,ConstantConditions
            o.toString();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
