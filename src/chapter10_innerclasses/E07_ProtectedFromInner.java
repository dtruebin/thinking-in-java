package chapter10_innerclasses;

/**
 * This exercise shows that inner classes have transparent access to their outer
 * class objects, even private fields and methods.
 */
class Outer {
    private int number = 10;

    private void f() {
        System.out.println(number);
    }

    void callInnerClassMethod() {
        new Inner().resetAndPrint();
    }

    class Inner {
        void resetAndPrint() {
            number = 0;
            f();
        }
    }
}

public class E07_ProtectedFromInner {
    public static void main(String[] args) {
        new Outer().callInnerClassMethod();
    }
}
