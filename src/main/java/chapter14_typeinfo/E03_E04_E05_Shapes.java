/*
Exercise 3:
Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then
downcast it back to a Rhomboid. Try downcasting to a Circle and see what
happens.

Exercise 4:
Modify the previous exercise so that it uses instanceof to check the type before
performing the downcast.

Exercise 5:
Implement a rotate(Shape) method in Shapes.java, such that it checks to see if
it is rotating a Circle (and, if so, doesn't perform the operation).
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
public class E03_E04_E05_Shapes {
    static Shape rotate(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Skipping rotation of the " + shape);
        } else {
            System.out.println("Rotating the " + shape);
        }
        return shape;
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape : shapeList) {
            shape.draw();
            rotate(shape);
        }
        Shape s = new Rhomboid();
        Rhomboid r = (Rhomboid) s;
        r.draw();
        if (s instanceof Circle) {
            Circle c = (Circle) s;
            c.draw();
        }
    }
}