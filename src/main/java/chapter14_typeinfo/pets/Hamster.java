package chapter14_typeinfo.pets;

public class Hamster extends Rodent {
    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }

    public static class Factory implements chapter14_typeinfo.factory.Factory<Hamster> {
        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}
