package main.java.chapter14_typeinfo.pets;

public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements main.java.chapter14_typeinfo.factory.Factory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
}
