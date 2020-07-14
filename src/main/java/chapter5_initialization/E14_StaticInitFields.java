package main.java.chapter5_initialization;

class SomeClass {
    static String str = "hello";
    static int c;

    static {
        c = 1;
    }
}

public class E14_StaticInitFields {
    public static void main(String[] args) {
        System.out.println(SomeClass.str);
        System.out.println(SomeClass.c);
        SomeClass.c = 3;
        System.out.println(SomeClass.c);
    }
}
