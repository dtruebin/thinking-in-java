/*
Exercise 10:
Create a class with two methods, f( ) and g( ). In g( ), throw an exception of a
new type that you define. In f( ), call g( ), catch its exception and, in the
catch clause, throw a different exception (of a second type that you define).
Test your code in main( ).

Exercise 11:
Repeat the previous exercise, but inside the catch clause, wrap g( )’s exception
in a RuntimeException.
 */

package chapter12_exceptions;

class CustomException1 extends Exception {
}

class Thrower {
    static void g() throws CustomException1 {
        System.out.println("Start of g()");
        throw new CustomException1();
    }

    static void f() {
        System.out.println("Start of f()");
        try {
            g();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class E10_E11_Rethrow {
    public static void main(String[] args) {
        try {
            Thrower.g();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thrower.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}