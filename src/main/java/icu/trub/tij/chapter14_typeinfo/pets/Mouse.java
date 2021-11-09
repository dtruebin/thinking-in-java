package icu.trub.tij.chapter14_typeinfo.pets;

public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements icu.trub.tij.chapter14_typeinfo.factory.Factory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
}
