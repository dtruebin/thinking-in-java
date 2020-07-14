package main.java.chapter5_initialization;

public class E08_ThisInMethodCalls {
    public static void main(String[] args) {
        E08_ThisInMethodCalls o = new E08_ThisInMethodCalls();
        o.method1();
    }

    void method1() {
        method2();
        this.method2();
    }

    void method2() {
        System.out.println("method2");
    }
}
