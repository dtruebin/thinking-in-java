package chapter11_holding;

import java.util.*;

/*
Create a generator class that produces character names (as String objects) from
your favorite movie (you can use Snow White or Star Wars as a fallback) each
time you call next( ), and loops around to the beginning of the character list
when it runs out of names. Use this generator to fill an array, an ArrayList,
a LinkedList, a HashSet, a LinkedHashSet, and a TreeSet, then print each
container.
*/

class Generator {
    private final String[] characters = {
            "Princess Leia",
            "Jango Fett",
            "Bobba Fett",
            "Luke Skywalker",
            "Jabba Hutt",
            "Han Solo",
            "Master Yoda"
    };
    private int currentIndex = 0;

    String next() {
        if (currentIndex >= characters.length) currentIndex = 0;
        return characters[currentIndex++];
    }
}

public class E04_GeneratorForCollections {
    public static void main(String[] args) {
        Generator g = new Generator();

        String[] array = new String[10];
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        for (int i = 0; i < array.length; i++) {
            String stringToAdd = g.next();

            array[i] = stringToAdd;
            arrayList.add(stringToAdd);
            linkedList.add(stringToAdd);
            hashSet.add(stringToAdd);
            linkedHashSet.add(stringToAdd);
            treeSet.add(stringToAdd);
        }

        System.out.println("Array:\n" + Arrays.toString(array));
        System.out.println("ArrayList:\n" + arrayList);
        System.out.println("LinkedList:\n" + linkedList);
        System.out.println("HashSet:\n" + hashSet);
        System.out.println("LinkedHashSet:\n" + linkedHashSet);
        System.out.println("TreeSet:\n" + treeSet);
    }
}
