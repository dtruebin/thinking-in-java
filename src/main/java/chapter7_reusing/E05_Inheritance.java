package main.java.chapter7_reusing;

class A {
    A() {
        System.out.println("Constructing A");
    }
}

class B {
    B() {
        System.out.println("Constructing B");
    }
}

class C extends A {
    B b = new B();
}

public class E05_Inheritance {
    public static void main(String[] args) {
        new C();
    }
}
