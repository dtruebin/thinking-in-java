package chapter8_polymorphism;

import chapter8_polymorphism.shape.RandomShapeGenerator;
import chapter8_polymorphism.shape.Shape;

public class E02_Shapes {
    private static final RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = gen.next();
        }

        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}
