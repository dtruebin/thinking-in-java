/*
Create a three-level hierarchy of exceptions. Now create a base-class A with a
method that throws an exception at the base of your hierarchy. Inherit B from A
and override the method so it throws an exception at level two of your
hierarchy. Repeat by inheriting class C from B. In main( ), create a C and
upcast it to A, then call the method.
 */

package main.java.chapter12_exceptions;

class BaseException extends Exception {
}

class SecondaryException extends BaseException {
}

class TertiaryException extends SecondaryException {
}

class A {
    void f() throws BaseException {
        throw new BaseException();
    }
}

class B extends A {
    @Override
    void f() throws SecondaryException {
        throw new SecondaryException();
    }
}

class C extends B {
    @Override
    void f() throws TertiaryException {
        throw new TertiaryException();
    }
}

public class E25_PolymorphicExceptions {
    public static void main(String[] args) {
        A obj = new C();
        try {
            obj.f();
        }
        // forced to catch the base one, due to obj's type
        catch (BaseException e) {
            // prints TertiaryException
            e.printStackTrace();
        }
    }
}
