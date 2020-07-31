package main.java.chapter14_typeinfo.pets;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }

    public static class Factory implements main.java.chapter14_typeinfo.factory.Factory<EgyptianMau> {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
