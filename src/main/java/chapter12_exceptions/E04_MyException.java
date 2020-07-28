/*
Create your own exception class using the extends keyword. Write a constructor
for this class that takes a String argument and stores it inside the object with
a String reference. Write a method that displays the stored String. Create a
try-catch clause to exercise your new exception.
 */

package main.java.chapter12_exceptions;

/*
Following the task to the letter here, but could simply overwrite the
constructor with String argument and call the superclass constructor from it
*/
class BoringSituationException extends Exception {
    String message;

    BoringSituationException(String s) {
        message = s;
    }

    void printMessage() {
        System.out.println("message = " + message);
    }
}

public class E04_MyException {
    public static void main(String[] args) {
        try {
            throw new BoringSituationException("Yawn");
        } catch (BoringSituationException e) {
            e.printMessage();
        }
    }
}
