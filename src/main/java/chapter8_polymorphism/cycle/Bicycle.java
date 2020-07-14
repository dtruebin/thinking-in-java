package main.java.chapter8_polymorphism.cycle;

public class Bicycle extends Cycle {
    public void ride() {
        System.out.println("I wanna ride my Bicycle");
    }

    @Override
    public int wheels() {
        return 2;
    }

    public void balance() {
        System.out.println("I balance my Bicycle");
    }
}
