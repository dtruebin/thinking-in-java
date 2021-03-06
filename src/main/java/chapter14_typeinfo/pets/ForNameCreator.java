package chapter14_typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static final List<Class<? extends Pet>> types =
            new ArrayList<>();
    // Types that you want to be randomly created:
    private static final String[] typeNames = {
            "chapter14_typeinfo.pets.Mutt",
            "chapter14_typeinfo.pets.Pug",
            "chapter14_typeinfo.pets.EgyptianMau",
            "chapter14_typeinfo.pets.Manx",
            "chapter14_typeinfo.pets.Cymric",
            "chapter14_typeinfo.pets.Rat",
            "chapter14_typeinfo.pets.Mouse",
            "chapter14_typeinfo.pets.Hamster"
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
