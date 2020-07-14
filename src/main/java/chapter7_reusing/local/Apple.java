package main.java.chapter7_reusing.local;

public class Apple extends Fruit {
    public void lick() {
        if (isBitten()) {
            System.out.println("Tried to lick the apple, but it's bitten already");
        } else {
            System.out.println("Licked: ooh wee!");
        }
    }
}
