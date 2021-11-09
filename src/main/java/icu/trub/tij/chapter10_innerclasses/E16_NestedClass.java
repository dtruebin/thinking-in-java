package icu.trub.tij.chapter10_innerclasses;

public class E16_NestedClass {
    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.value);
    }

    static class Nested {
        int value = 42;
    }
}
