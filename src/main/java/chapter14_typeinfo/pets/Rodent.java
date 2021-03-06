package chapter14_typeinfo.pets;

public class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    public static class Factory implements chapter14_typeinfo.factory.Factory<Rodent> {
        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
}
