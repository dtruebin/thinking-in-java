/*
Create a class with two methods, f( ) and g( ). In g( ), throw an exception of a
new type that you define. In f( ), call g( ), catch its exception and, in the
catch clause, throw a different exception (of a second type that you define).
Test your code in main( ).
 */

package main.java.chapter12_exceptions;

class CustomException1 extends Exception {
}

class CustomException2 extends Exception {
}

class Thrower {
    static void g() throws CustomException1 {
        System.out.println("Start of g()");
        throw new CustomException1();
    }

    static void f() throws CustomException2 {
        System.out.println("Start of f()");
        try {
            g();
        } catch (Exception e) {
            throw new CustomException2();
        }
    }
}

public class E10_Rethrow {
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
