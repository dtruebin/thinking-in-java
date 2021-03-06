package chapter14_typeinfo.pets;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    public static class Factory implements chapter14_typeinfo.factory.Factory<Cymric> {
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}
