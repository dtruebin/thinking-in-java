package icu.trub.tij.chapter9_interfaces;

import icu.trub.tij.chapter9_interfaces.local.E05_Animal;

public class E05_Fox implements E05_Animal {
    public static void main(String[] args) {
        E05_Fox fox = new E05_Fox();
        fox.whoami();
        System.out.println("and I have " + fox.getAmountOfLegs() + " legs");
        System.out.println("What does the fox say? — ");
        fox.say();
    }

    @Override
    public void whoami() {
        System.out.println("I'm a fox");
    }

    @Override
    public void say() {
        System.out.println("A-hee-ahee ha-hee!");
    }

    @Override
    public int getAmountOfLegs() {
        return 4;
    }
}
