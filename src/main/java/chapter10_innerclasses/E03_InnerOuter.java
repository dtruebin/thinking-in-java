package main.java.chapter10_innerclasses;

public class E03_InnerOuter {
    public static void main(String[] args) {
        Outer outer = new Outer("Content");
        Outer.Inner inner = outer.createInner();
        System.out.println(inner.toString());
    }

    private static class Outer {
        private final String str;

        Outer(String s) {
            str = s;
            System.out.println("Outer class instance created");
        }

        Inner createInner() {
            return new Inner();
        }

        class Inner {

            {
                System.out.println("Inner class instance created");
            }

            @Override
            public String toString() {
                return str;
            }

        }
    }
}

