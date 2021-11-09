package icu.trub.tij.chapter3_operators;

import java.util.Random;

class Coin {
    String flip() {
        return new Random().nextBoolean() ? "heads" : "tails";
    }
}

public class E07_CoinFlip {
    public static void main(String[] args) {
        Coin coin = new Coin();
        int numberOfFlips = Integer.parseInt(args[0]);

        System.out.println("Flipping " + numberOfFlips + " coins:");

        for (int i = 1; i <= numberOfFlips; i++) {
            System.out.println(i + ": " + coin.flip());
        }
    }
}
