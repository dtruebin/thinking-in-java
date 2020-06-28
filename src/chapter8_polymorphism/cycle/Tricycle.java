package chapter8_polymorphism.cycle;

public class Tricycle extends Cycle {
    public void ride() {
        System.out.println("I wanna ride my Tricycle");
    }

    @Override
    public int wheels() {
        return 3;
    }
}
