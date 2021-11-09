package icu.trub.tij.chapter14_typeinfo.pets;

public class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }

    public static class Factory implements icu.trub.tij.chapter14_typeinfo.factory.Factory<Rat> {
        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
