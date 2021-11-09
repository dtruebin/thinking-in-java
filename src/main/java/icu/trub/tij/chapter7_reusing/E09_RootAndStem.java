package icu.trub.tij.chapter7_reusing;

class Component1 {
    Component1() {
        System.out.println("Creating an instance of " + this.getClass().getName());
    }

    void dispose() {
        System.out.println("Disposing of the instance of " + this.getClass().getName());
    }
}

class Component2 {
    Component2() {
        System.out.println("Creating an instance of " + this.getClass().getName());
    }

    void dispose() {
        System.out.println("Disposing of the instance of " + this.getClass().getName());
    }
}

class Component3 {
    Component3() {
        System.out.println("Creating an instance of " + this.getClass().getName());
    }

    void dispose() {
        System.out.println("Disposing of the instance of " + this.getClass().getName());
    }
}

class Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    Root() {
        System.out.println("Creating an instance of Root");
    }

    void dispose() {
        System.out.println("Disposing of the instance of Root");
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}

class Stem extends Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    Stem() {
        super();
        System.out.println("Creating an instance of Stem");
    }

    void dispose() {
        System.out.println("Disposing of the instance of Stem");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
    }
}


public class E09_RootAndStem {
    public static void main(String[] args) {
        Stem stem = new Stem();
        stem.dispose();
    }
}
