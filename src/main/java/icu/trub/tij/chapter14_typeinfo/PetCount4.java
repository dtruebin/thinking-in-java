package icu.trub.tij.chapter14_typeinfo;

import icu.trub.tij.chapter14_typeinfo.pets.Pet;
import icu.trub.tij.chapter14_typeinfo.pets.Pets;
import icu.trub.util.TypeCounter;

public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
} /* Output: (Sample)
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Hamster=1, Rodent=5, Manx=7, Mutt=3, Rat=2, Pug=3, Mouse=2, Cymric=5, Dog=6, Pet=20, Cat=9, EgyptianMau=2}
*///:~
