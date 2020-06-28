package chapter8_polymorphism;

import chapter8_polymorphism.cycle.Bicycle;
import chapter8_polymorphism.cycle.Cycle;
import chapter8_polymorphism.cycle.Tricycle;
import chapter8_polymorphism.cycle.Unicycle;

public class E01_Cycle {
    public static void main(String[] args) {
        ride(new Cycle());
        ride(new Unicycle());
        ride(new Bicycle());
        ride(new Tricycle());

        Cycle cycle = new Bicycle();
        cycle.ride();
    }

    static void ride(Cycle c) {
        c.ride();
    }
}
