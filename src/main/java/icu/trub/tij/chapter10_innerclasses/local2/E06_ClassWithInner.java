package icu.trub.tij.chapter10_innerclasses.local2;

import icu.trub.tij.chapter10_innerclasses.local.E06_Interface;

public class E06_ClassWithInner {
    protected class Inner implements E06_Interface {
        public Inner() {
            System.out.println("Created E06_ClassWithInner.Inner");
        }

        @Override
        public void f() {
            System.out.println("E06_ClassWithInner.Inner.f()");
        }
    }
}
