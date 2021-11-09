/*
Write a method that uses an Iterator to step through a Collection and print
the toString( ) of each object in the container. Fill all the different types
of Collections with objects and apply your method to each container.
 */

package icu.trub.tij.chapter11_holding;

import java.util.*;

public class E11_IterateOverCollections {
    static void display(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        //noinspection WhileLoopReplaceableByForEach
        while (it.hasNext()) {
            System.out.print(it.next() + " | ");
        }
        System.out.println();
    }

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

        display(Arrays.asList(array));
        display(arrayList);
        display(linkedList);
        display(hashSet);
        display(linkedHashSet);
        display(treeSet);
    }
}