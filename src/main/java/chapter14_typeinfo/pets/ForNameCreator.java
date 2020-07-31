package main.java.chapter14_typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static final List<Class<? extends Pet>> types =
            new ArrayList<>();
    // Types that you want to be randomly created:
    private static final String[] typeNames = {
            "main.java.chapter14_typeinfo.pets.Mutt",
            "main.java.chapter14_typeinfo.pets.Pug",
            "main.java.chapter14_typeinfo.pets.EgyptianMau",
            "main.java.chapter14_typeinfo.pets.Manx",
            "main.java.chapter14_typeinfo.pets.Cymric",
            "main.java.chapter14_typeinfo.pets.Rat",
            "main.java.chapter14_typeinfo.pets.Mouse",
            "main.java.chapter14_typeinfo.pets.Hamster"
    };

    static {
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add(
                        (Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
}
