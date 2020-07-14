package main.java.chapter5_initialization;

public class E09_CallConstructorFromConstructor {
    E09_CallConstructorFromConstructor() {
        System.out.println("Default constructor");
    }

    E09_CallConstructorFromConstructor(String s) {
        this();
        System.out.println("Constructor with String: " + s);
    }

    public static void main(String[] args) {
        E09_CallConstructorFromConstructor o = new E09_CallConstructorFromConstructor("Hallöchen!");
    }
}
