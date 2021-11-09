package icu.trub.tij.chapter14_typeinfo.pets;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static class Factory implements icu.trub.tij.chapter14_typeinfo.factory.Factory<Dog> {
        @Override
        public Dog create() {
            return new Dog();
        }
    }
}
