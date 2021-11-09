/*
Exercise 8:
Write a method that takes an object and recursively prints all the classes in
that object’s hierarchy.

Exercise 9:
Modify the previous exercise so that it uses Class.getDeclaredFields( ) to also
display information about the fields in a class.
 */

package icu.trub.tij.chapter14_typeinfo;

import java.lang.reflect.Field;

class Top {
    protected int topField;
}

class Middle extends Top {
    private final String middleField = "Yo";
    Side s;

    static class Side {
    }
}

class Bottom extends Middle {
    static long bottomField1;
    double bottomField2 = topField;
}


public class E08_09_ClassHierarchyAndFields {
    static void printClassHierarchy(Class<?> c) {
        System.out.println(c.getName());
        for (Field field : c.getDeclaredFields()) {
            System.out.println("- " + field);
        }
        if (c.getSuperclass() != null) {
            printClassHierarchy(c.getSuperclass());
        }
    }

    static void printClassHierarchy(Object o) {
        printClassHierarchy(o.getClass());
    }

    public static void main(String[] args) {
        printClassHierarchy(new Bottom());
    }
}
