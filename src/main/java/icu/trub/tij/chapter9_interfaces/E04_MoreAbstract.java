package icu.trub.tij.chapter9_interfaces;

/*// before — need to downcast
abstract class E04SuperClass {
}*/

// after — no need to downcast
abstract class E04SuperClass {
    abstract void f();
}

class E04SubClass extends E04SuperClass {
    @Override
    void f() {
        System.out.println("E04SubClass.f()");
    }
}

public class E04_MoreAbstract {
    public static void main(String[] args) {
        doSomething(new E04SubClass());
    }

    /*// before — need to downcast
    public static void doSomething(E04SuperClass o) {
        ((E04SubClass) o).f();
    }*/

    // after — no need to downcast
    public static void doSomething(E04SuperClass o) {
        o.f();
    }
}
