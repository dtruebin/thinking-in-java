package icu.trub.tij.chapter8_polymorphism;

import icu.trub.tij.chapter8_polymorphism.cycle.Bicycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Cycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Tricycle;
import icu.trub.tij.chapter8_polymorphism.cycle.Unicycle;

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
