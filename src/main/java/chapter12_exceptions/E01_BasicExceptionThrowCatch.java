/*
Create a class with a main( ) that throws an object of class Exception inside a
try block. Give the constructor for Exception a String argument. Catch the
exception inside a catch clause and print the String argument. Add a finally
clause and print a message to prove you were there.
 */

package chapter12_exceptions;

public class E01_BasicExceptionThrowCatch {
    public static void main(String[] args) {
        try {
            throw new Exception("Oops");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Inside the `finally` clause");
        }
    }
}
