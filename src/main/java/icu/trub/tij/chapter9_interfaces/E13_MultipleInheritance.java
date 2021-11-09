package icu.trub.tij.chapter9_interfaces;

interface BaseInterface {
    void f1();
}

interface IntermediaryInterface1 extends BaseInterface {
    void f1();
}

interface IntermediaryInterface2 extends BaseInterface {
    void f1();
}

interface CombinedInterface extends IntermediaryInterface1, IntermediaryInterface2 {
    void f1();
}

class CombinedImpl implements CombinedInterface {
    @Override
    public void f1() {
        System.out.println("CombinedImpl.f1()");
    }
}

public class E13_MultipleInheritance {
    public static void main(String[] args) {
        new CombinedImpl().f1();
    }
}
