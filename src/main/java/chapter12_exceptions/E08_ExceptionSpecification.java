/*
Write a class with a method that throws an exception of the type created in
Exercise 4. Try compiling it without an exception specification to see what the
compiler says. Add the appropriate exception specification. Try out your class
and its exception inside a try-catch clause.
 */

package chapter12_exceptions;

import java.util.Random;

class Clown {
    void succeed() {
        System.out.println("LOL");
    }

    void fail()
            /*
             Won't compile otherwise, with the following message:
             "unreported exception main.<...>.BoringSituationException; must be caught or declared to be thrown"
             */
            throws BoringSituationException {
        throw new BoringSituationException("Bad joke");
    }

    void joke() throws BoringSituationException {
        if (new Random().nextBoolean()) {
            succeed();
        } else {
            fail();
        }
    }
}

public class E08_ExceptionSpecification {
    public static void main(String[] args) {
        Clown clown = new Clown();
        for (int i = 0; i < 5; i++) {
            try {
                clown.joke();
            } catch (BoringSituationException e) {
                e.printMessage();
            }
        }
    }
}
