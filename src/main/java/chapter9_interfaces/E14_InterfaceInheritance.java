package chapter9_interfaces;

interface OneTwo {
    void one();

    void two();
}

interface ThreeFour {
    void three();

    void four();
}

interface FiveSix {
    void five();

    void six();
}

interface Mega extends OneTwo, ThreeFour, FiveSix {
    void mega();
}

class BaseClass {
    String name = "BaseClass";
}

class MegaSubClass extends BaseClass implements Mega {

    @Override
    public void one() {
        System.out.println("one");
    }

    @Override
    public void two() {
        System.out.println("two");
    }

    @Override
    public void three() {
        System.out.println("three");
    }

    @Override
    public void four() {
        System.out.println("four");
    }

    @Override
    public void five() {
        System.out.println("five");
    }

    @Override
    public void six() {
        System.out.println("six");
    }

    @Override
    public void mega() {
        System.out.println("mega");
    }
}

public class E14_InterfaceInheritance {
    static void a(OneTwo o) {
        o.one();
        o.two();
    }

    static void b(ThreeFour o) {
        o.three();
        o.four();
    }

    static void c(FiveSix o) {
        o.five();
        o.six();
    }

    static void d(Mega o) {
        o.one();
        o.two();
        o.three();
        o.four();
        o.five();
        o.six();
        o.mega();
    }

    public static void main(String[] args) {
        MegaSubClass obj = new MegaSubClass();

        a(obj);
        b(obj);
        c(obj);
        d(obj);
    }
}
