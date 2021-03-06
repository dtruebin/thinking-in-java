package chapter14_typeinfo.pets;

public class Pet extends Individual {
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }

    public static class Factory implements chapter14_typeinfo.factory.Factory<Pet> {
        @Override
        public Pet create() {
            return new Pet();
        }
    }
}
