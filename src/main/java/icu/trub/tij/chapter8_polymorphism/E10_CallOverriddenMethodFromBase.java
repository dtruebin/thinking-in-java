package icu.trub.tij.chapter8_polymorphism;

class Base {
    void f1() {
        f2();
    }

    void f2() {
        System.out.println("I am Base");
    }
}

class Child extends Base {
    @Override
    void f2() {
        System.out.println("I am Child");
    }
}

public class E10_CallOverriddenMethodFromBase {
    public static void main(String[] args) {
        Base o = new Child();
        o.f1();
    }
}
