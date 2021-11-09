package icu.trub.tij.chapter8_polymorphism.shape;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable<Shape> {
    private final Random rand = new Random();
    private final int amount;

    public RandomShapeGenerator() {
        this(0);
    }

    public RandomShapeGenerator(int amount) {
        this.amount = amount;
    }

    public Shape next() {
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

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < amount;
            }

            @Override
            public Shape next() {
                index++;
                return RandomShapeGenerator.this.next();
            }
        };
    }
}
