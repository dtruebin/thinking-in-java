package main.java.chapter8_polymorphism;

import main.java.chapter8_polymorphism.cycle.Bicycle;
import main.java.chapter8_polymorphism.cycle.Cycle;
import main.java.chapter8_polymorphism.cycle.Tricycle;
import main.java.chapter8_polymorphism.cycle.Unicycle;

public class E18_CycleDowncasting {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        ((Unicycle) cycles[0]).balance();
        ((Bicycle) cycles[1]).balance();
//        ((Tricycle) cycles[2]).balance();
    }

    static void ride(Cycle c) {
        c.ride();
    }
}
