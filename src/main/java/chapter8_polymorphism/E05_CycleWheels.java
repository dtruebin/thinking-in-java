package main.java.chapter8_polymorphism;

import main.java.chapter8_polymorphism.cycle.Bicycle;
import main.java.chapter8_polymorphism.cycle.Cycle;
import main.java.chapter8_polymorphism.cycle.Unicycle;

public class E05_CycleWheels {
    public static void main(String[] args) {
        ride(new Cycle());
        ride(new Unicycle());
        ride(new Bicycle());

        Cycle cycle = new Bicycle();
        cycle.ride();
    }

    static void ride(Cycle c) {
        System.out.println("I'll ride a transport with " + c.wheels() + " wheels");
    }
}
