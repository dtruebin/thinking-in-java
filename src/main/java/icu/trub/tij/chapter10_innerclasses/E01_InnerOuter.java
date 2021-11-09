package icu.trub.tij.chapter10_innerclasses;

public class E01_InnerOuter {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.createInner();
    }

    private static class Outer {
        Inner createInner() {
            return new Inner();
        }

        class Inner {
            {
                System.out.println("Inner object created");
            }
        }
    }
}
