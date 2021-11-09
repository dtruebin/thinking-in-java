package icu.trub.tij.chapter14_typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static final List<Class<? extends Pet>> types =
            new ArrayList<>();
    // Types that you want to be randomly created:
    private static final String[] typeNames = {
            "icu.trub.tij.chapter14_typeinfo.pets.Mutt",
            "icu.trub.tij.chapter14_typeinfo.pets.Pug",
            "icu.trub.tij.chapter14_typeinfo.pets.EgyptianMau",
            "icu.trub.tij.chapter14_typeinfo.pets.Manx",
            "icu.trub.tij.chapter14_typeinfo.pets.Cymric",
            "icu.trub.tij.chapter14_typeinfo.pets.Rat",
            "icu.trub.tij.chapter14_typeinfo.pets.Mouse",
            "icu.trub.tij.chapter14_typeinfo.pets.Hamster"
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
