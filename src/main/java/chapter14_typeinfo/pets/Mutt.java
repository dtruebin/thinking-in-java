package chapter14_typeinfo.pets;

public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }

    public static class Factory implements chapter14_typeinfo.factory.Factory<Mutt> {
        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
