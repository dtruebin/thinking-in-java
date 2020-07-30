/*
Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then
downcast it back to a Rhomboid. Try downcasting to a Circle and see what
happens.
 */

package main.java.chapter14_typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

@SuppressWarnings("ConstantConditions")
public class E03_Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape : shapeList) {
            shape.draw();
        }
        Shape s = new Rhomboid();
        Rhomboid r = (Rhomboid) s;
        r.draw();
        Circle c = (Circle) s;
        try {
            c.draw();
        } catch (ClassCastException cse) {
            cse.printStackTrace();
        }
    }
}