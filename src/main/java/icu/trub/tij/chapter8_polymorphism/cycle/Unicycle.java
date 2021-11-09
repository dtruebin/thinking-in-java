package icu.trub.tij.chapter8_polymorphism.cycle;

public class Unicycle extends Cycle {
    public void ride() {
        System.out.println("I wanna ride my Unicycle");
    }

    @Override
    public int wheels() {
        return 1;
    }

    public void balance() {
        System.out.println("I balance my Unicycle");
    }
}
