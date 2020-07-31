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

Exercise 6:
Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of a
particular type. The toString( ) method for each derived Shape should indicate
whether that Shape is "highlighted."
 */

package main.java.chapter14_typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Shape {
    private static final List<Shape> shapes = new ArrayList<>();
    private boolean isHighlighted;

    Shape() {
        shapes.add(this);
    }

    static void highlightAll(Class<?> c) {
        for (Shape shape : shapes) {
            if (c.isInstance(shape)) {
                shape.highlight();
            } else {
                shape.unhighlight();
            }
        }
    }

    void draw() {
        System.out.println(this + " draw()");
    }

    void highlight() {
        isHighlighted = true;
    }

    void unhighlight() {
        isHighlighted = false;
    }

    void rotate(int deg) {
        System.out.println("Rotating " + this + " by " + deg + "°");
    }

    public String toString() {
        return this.getClass().getSimpleName() + (isHighlighted ? " (highlighted)" : "");
    }
}

class Circle extends Shape {
    void rotate(int deg) {
        throw new UnsupportedOperationException("Can't rotate a circle");
    }
}

class Rhomboid extends Shape {
}

class Rectangle extends Shape {
}

class Square extends Rectangle {
}

class Triangle extends Shape {
}

@SuppressWarnings("ConstantConditions")
public class E03_E04_E05_E06_Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        Shape.highlightAll(Rectangle.class);
        for (Shape shape : shapeList) {
            shape.draw();
            if (!(shape instanceof Circle)) {
                shape.rotate(30);
            }
        }
        Shape s = new Rhomboid();
        Rhomboid r = (Rhomboid) s;
        Shape.highlightAll(Rhomboid.class);
        r.draw();
        if (s instanceof Circle) {
            Circle c = (Circle) s;
            c.draw();
        }
    }
}