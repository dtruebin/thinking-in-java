package main.java.chapter14_typeinfo.pets;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory implements main.java.chapter14_typeinfo.factory.Factory<Cat> {
        @Override
        public Cat create() {
            return new Cat();
        }
    }
}
