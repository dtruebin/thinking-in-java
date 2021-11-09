// Facade to produce a default PetCreator.
package icu.trub.tij.chapter14_typeinfo.pets;

import java.util.ArrayList;

public class Pets {
    public static final PetCreator creator =
            new RegisteredFactoriesPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
