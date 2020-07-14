package main.java.chapter9_interfaces;

abstract class Superclass {
    Superclass() {
        print();
    }

    abstract void print();
}

class Subclass extends Superclass {
    int i = 5;

    @Override
    void print() {
        System.out.println("i = " + i);
    }
}

public class E03_AbstractPrint {
    public static void main(String[] args) {
        Subclass o = new Subclass();
        o.print();
    }
}
