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
    static void printClassHierarchy(Object o) {
        Class<?> c = o.getClass();
        System.out.println(c.getName());
        if (c.getSuperclass() != Object.class) {
            try {
                printClassHierarchy(c.getSuperclass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        printClassHierarchy(new Bottom());
    }
}
