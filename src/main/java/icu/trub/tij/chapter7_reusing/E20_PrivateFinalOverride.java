package icu.trub.tij.chapter7_reusing;

class WithFinals {
    @SuppressWarnings("FinalPrivateMethod")
    private final void f() {
        System.out.println("WithFinals f()");
    }

    private void g() {
        System.out.println("WithFinals g()");
    }
}

class Overrider extends WithFinals {
    @SuppressWarnings("FinalPrivateMethod")
    private final void f() {
        System.out.println("Overrider f()");
    }

    private void g() {
        System.out.println("Overrider g()");
    }
}

class Overrider2 extends Overrider {
    public final void f() {
        System.out.println("Overrider2 f()");
    }

    public void g() {
        System.out.println("Overrider2 g()");
    }
}

public class E20_PrivateFinalOverride {
    public static void main(String[] args) {
        Overrider2 o2 = new Overrider2();
        o2.f();
        o2.g();
    }
}
