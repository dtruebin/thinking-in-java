package main.java.chapter8_polymorphism.shape;

import java.util.Random;

public class RandomShapeGenerator {
    private final Random rand = new Random();

    public Shape next() {
        //noinspection EnhancedSwitchMigration
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}
