/*
Create and populate a List<Integer>. Create a second List<Integer> of the same
size as the first, and use ListIterators to read elements from the first List
and insert them into the second in reverse order. (You may want to explore
a number of different ways to solve this problem.)
 */

package main.java.chapter11_holding;

import java.util.*;

public class E12_ListIterator {
    /**
     * Reverses a list
     *
     * @param list list to be reversed
     */
    static void reverse(List<Integer> list) {
        ListIterator<Integer> fwd = list.listIterator();
        ListIterator<Integer> rev = list.listIterator(list.size());
        int mid = list.size() >> 1;

        for (int i = 0; i < mid; i++) {
            Integer temp = fwd.next();
            fwd.set(rev.previous());
            rev.set(temp);
        }
    }

    /**
     * Reverses a list
     *
     * @param source      list to be reversed
     * @param destination list where reversion result will be placed into
     */
    static void reverse(List<Integer> source, List<Integer> destination) {
        destination.clear();
        destination.addAll(source);

        ListIterator<Integer> listIterator1 = source.listIterator(source.size());
        ListIterator<Integer> listIterator2 = destination.listIterator();

        while (listIterator1.hasPrevious()) {
            listIterator2.next();
            listIterator2.set(listIterator1.previous());
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(list1);

        reverse(list1, list2);
        System.out.println(list2);

        reverse(list2);
        System.out.println(list2);
    }
}
