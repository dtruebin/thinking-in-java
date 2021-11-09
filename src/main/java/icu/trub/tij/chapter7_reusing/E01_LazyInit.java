package icu.trub.tij.chapter7_reusing;

class Nested {
    String string = "Hi";

    public String toString() {
        return "IncludeMe{" +
                "string='" + string + '\'' +
                '}';
    }
}

class Includer {
    private static int counter = 0;
    private final int id;
    private Nested nestedObject;

    Includer() {
        id = counter++;
    }

    void printNestedObjectStatus() {
        if (nestedObject == null) {
            System.out.println("nestedObject not yet initialized");
        } else {
            System.out.println("nestedObject already initialized");
        }
    }

//    public String toString() {
//        if (nestedObject == null){
//            nestedObject = new Nested();
//        }
//        return "obj #" + (counter++) + " " + nestedObject;
//    }

    Nested getNestedObject() {
        if (nestedObject == null) {
            nestedObject = new Nested();
        }
        return nestedObject;
    }

    public String toString() {
        return "obj #" + id + " " + getNestedObject();
    }
}

public class E01_LazyInit {
    public static void main(String[] args) {
        Includer includer = new Includer();
        includer.printNestedObjectStatus();
        System.out.println(includer);
        includer.printNestedObjectStatus();
    }
}

