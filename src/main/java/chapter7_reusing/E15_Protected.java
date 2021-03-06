package chapter7_reusing;

import chapter7_reusing.local.Apple;
import chapter7_reusing.local.Fruit;

public class E15_Protected {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.bite();

        Apple apple = new Apple();
        apple.lick();
        apple.bite();
        apple.lick();
    }
}
