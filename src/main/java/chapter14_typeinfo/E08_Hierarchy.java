/*
Write a method that takes an object and recursively prints all the classes in
that object’s hierarchy.
 */

package main.java.chapter14_typeinfo;

class Top {
}

class Middle extends Top {
}

class Bottom extends Middle {
}


public class E08_Hierarchy {
    static void printClassHierarchy(Class<?> c) {
        System.out.println(c.getName());
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
