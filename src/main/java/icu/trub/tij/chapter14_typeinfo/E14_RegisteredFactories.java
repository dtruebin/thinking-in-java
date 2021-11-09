/*
A constructor is a kind of factory method. Modify RegisteredFactories.java so
that instead of using an explicit factory, the class object is stored in the
List, and newInstance( ) is used to create each object.
 */

package icu.trub.tij.chapter14_typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Part {
    private static final Random rand = new Random(47);
    // Registering Class Factories in the base class.
    static List<Class<? extends Part>> partClasses =
            Arrays.asList(FuelFilter.class, AirFilter.class, CabinAirFilter.class, OilFilter.class, FanBelt.class,
                    PowerSteeringBelt.class, GeneratorBelt.class);

    public static Part createRandom() {
        Part part;
        int n = rand.nextInt(partClasses.size());
        try {
            part = partClasses.get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return part;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
}

class AirFilter extends Filter {
}

class CabinAirFilter extends Filter {
}

class OilFilter extends Filter {
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class GeneratorBelt extends Belt {
}

class PowerSteeringBelt extends Belt {
}

public class E14_RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
} /* Output:
GeneratorBelt
CabinAirFilter
GeneratorBelt
AirFilter
PowerSteeringBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
PowerSteeringBelt
FuelFilter
*///:~
