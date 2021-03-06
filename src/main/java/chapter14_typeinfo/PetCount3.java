// Using isInstance()
package chapter14_typeinfo;

import chapter14_typeinfo.pets.LiteralPetCreator;
import chapter14_typeinfo.pets.Pet;
import chapter14_typeinfo.pets.Pets;
import util.MapData;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
  public static void main(String[] args) {
    PetCounter petCount = new PetCounter();
    for (Pet pet : Pets.createArray(20)) {
      System.out.print(pet.getClass().getSimpleName() + " ");
      petCount.count(pet);
    }
    System.out.println();
    System.out.println(petCount);
  }

  static class PetCounter
          extends LinkedHashMap<Class<? extends Pet>, Integer> {
    public PetCounter() {
      super(MapData.map(LiteralPetCreator.allTypes, 0));
    }

    public void count(Pet pet) {
      // Class.isInstance() eliminates instanceOfs:
      for (Map.Entry<Class<? extends Pet>, Integer> pair
              : entrySet())
        if (pair.getKey().isInstance(pet))
          put(pair.getKey(), pair.getValue() + 1);
    }

    public String toString() {
      StringBuilder result = new StringBuilder("{");
      for (Map.Entry<Class<? extends Pet>, Integer> pair
              : entrySet()) {
        result.append(pair.getKey().getSimpleName());
        result.append("=");
        result.append(pair.getValue());
        result.append(", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("}");
      return result.toString();
    }
  }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*///:~
