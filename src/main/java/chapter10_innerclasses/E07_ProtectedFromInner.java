package main.java.chapter10_innerclasses;

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

    // Shows that private members of inner class are accessible from the outer
    String getInnerStringE08() {
        return new Inner().sE08;
    }

    class Inner {
        private final String sE08 = "E08";

        void resetAndPrint() {
            number = 0;
            f();
        }
    }
}

public class E07_ProtectedFromInner {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.callInnerClassMethod();
        System.out.println(o.getInnerStringE08());
    }
}
