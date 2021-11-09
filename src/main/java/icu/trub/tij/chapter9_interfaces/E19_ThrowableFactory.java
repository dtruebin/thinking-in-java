package icu.trub.tij.chapter9_interfaces;

import java.util.Random;
import java.util.Scanner;

enum TabletopGameRandomizer {
    COIN, DICE
}

interface Throwable {
    String getOutcome();
}

class Dice implements Throwable {
    int roll() {
        return new Random().nextInt(6) + 1;
    }

    @Override
    public String getOutcome() {
        return "Rolled a dice: " + roll();
    }
}

class Coin implements Throwable {
    String flip() {
        if (new Random().nextBoolean()) {
            return "heads";
        } else {
            return "tails";
        }
    }

    @Override
    public String getOutcome() {
        return "Flipped a coin: " + flip();
    }
}

class ThrowableFactory {
    Throwable getThrowable(TabletopGameRandomizer t) {
        Throwable product = null;

        switch (t) {
            case COIN:
                product = new Coin();
                break;
            case DICE:
                product = new Dice();
                break;
        }

        return product;
    }
}

public class E19_ThrowableFactory {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        ThrowableFactory tf = new ThrowableFactory();
        Throwable t;

        System.out.println("Available tabletop game randomizers:");
        for (TabletopGameRandomizer tool :
                TabletopGameRandomizer.values()) {
            System.out.println(tool.name());
        }

        System.out.println("Which of them do you want to throw? (case insensitive)");
        while (sc.hasNextLine()) {
            try {
                t = tf.getThrowable(
                        TabletopGameRandomizer.valueOf(sc.nextLine().toUpperCase())
                );
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such kind.");
                continue;
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(i + " — " + t.getOutcome());
            }
        }
    }
}
