/*
Create an empty LinkedList<Integer>. Using a ListIterator, add Integers to
the List by always inserting them in the middle of the List.
 */

package main.java.chapter11_holding;

import java.util.LinkedList;
import java.util.ListIterator;

public class E14_ListIteratorMiddleInsert {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator();

        for (int i = 0; i < 20; i++) {
            iterator.add(i);
            if (list.size() % 2 == 0) {
                iterator.previous();
            }
            System.out.println(list);
        }
    }
}
