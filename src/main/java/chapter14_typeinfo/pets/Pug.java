package main.java.chapter14_typeinfo.pets;

public class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    public static class Factory implements main.java.chapter14_typeinfo.factory.Factory<Pug> {
        @Override
        public Pug create() {
            return new Pug();
        }
    }
}
