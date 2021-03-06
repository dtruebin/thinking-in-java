package chapter10_innerclasses;

import chapter10_innerclasses.local.E06_Interface;
import chapter10_innerclasses.local2.E06_ClassWithInner;

public class E06_SubClass extends E06_ClassWithInner {
    public static void main(String[] args) {
        E06_Interface inner = new E06_SubClass().getInner();
        inner.f();
    }

    E06_Interface getInner() {
        return new Inner();
    }
}
