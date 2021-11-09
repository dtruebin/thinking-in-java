package icu.trub.tij.chapter8_polymorphism;

import icu.trub.tij.chapter8_polymorphism.cycle.Bicycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Cycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Tricycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Unicycle;

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
