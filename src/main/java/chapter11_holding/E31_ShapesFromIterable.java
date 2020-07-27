package main.java.chapter11_holding;

import main.java.chapter8_polymorphism.shape.RandomShapeGenerator;
import main.java.chapter8_polymorphism.shape.Shape;

public class E31_ShapesFromIterable {
    private static final RandomShapeGenerator gen = new RandomShapeGenerator(9);

    public static void main(String[] args) {
        for (Shape shape : gen) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}
