package icu.trub.tij.chapter14_typeinfo.pets;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory implements icu.trub.tij.chapter14_typeinfo.factory.Factory<Cat> {
        @Override
        public Cat create() {
            return new Cat();
        }
    }
}
