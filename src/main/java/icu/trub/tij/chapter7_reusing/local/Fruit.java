package icu.trub.tij.chapter7_reusing.local;

public class Fruit {
    private boolean bitten = false;

    public Fruit() {
    }

    protected boolean isBitten() {
        return bitten;
    }

    public void bite() {
        bitten = true;
        System.out.println("Bitten: om nom!");
    }
}
