/*
Implement a new PetCreator using Registered Factories, and modify the Pets
Facade so that it uses this one instead of the other two. Ensure that the rest
of the examples that use Pets.java still work correctly.
 */
package main.java.chapter14_typeinfo.pets;

import main.java.chapter14_typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegisteredFactoriesPetCreator extends PetCreator {
    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();

    // Listing base classes for convenience, but we only ned "concrete" pets here
    static {
//        petFactories.add(new Pet.Factory());
//        petFactories.add(new Dog.Factory());
//        petFactories.add(new Cat.Factory());
//        petFactories.add(new Rodent.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Cymric.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Hamster.Factory());
    }

    private final Random rand = new Random(47);

    @Override
    public List<Class<? extends Pet>> types() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pet randomPet() {
        return petFactories.get(rand.nextInt(petFactories.size())).create();
    }
}
