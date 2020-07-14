package main.java.chapter3_operators;

class Dog {
    String name, says;
}

public class E05_Dogs {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();

        Dog[] dogs = new Dog[2];
        dogs[0] = spot;
        dogs[1] = scruffy;

        spot.name = "Spot";
        spot.says = "Yo!";

        scruffy.name = "Scruffy";
        scruffy.says = "Hello!";

        for (Dog dog :
                dogs) {
            System.out.println("operators.Dog " + dog.name + " says: \"" + dog.says + "\"");
        }

        @SuppressWarnings("UnnecessaryLocalVariable")
        Dog anotherSpot = spot;

        System.out.println(anotherSpot == spot);
        System.out.println(anotherSpot.equals(spot));

        System.out.println("== on top references: " + (spot == scruffy));
    }
}
