package util;

import datastructures.MyArrayList;
import datastructures.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    static Stopwatch s = new Stopwatch();

    static void populate(List<Long> list, long n) {
        for (long i = 0; i < n; i++) {
            list.add(i);
        }
    }

    // TODO make tic-do-toc part reusable. Method taking another method as
    //  parameter? Lambdas?
    // TODO figure out a better way to store/present the measured results
    static void measure(List<Long> list, long n) {
        System.out.println("Measuring performance of " + list.getClass().getName() + " with " + n + " elements");

        s.tic();
        for (long i = 0; i < n; i++) {
            list.add(i);
        }
        s.tocAndPrint("Append");

        s.tic();
        for (long i = 0; i < n; i++) {
            //noinspection ResultOfMethodCallIgnored - no need to store it
            list.get((int) i);
        }
        s.tocAndPrint("Get by index");

        s.tic();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
        s.tocAndPrint("Remove by index from beginning");

        populate(list, n);
        s.tic();
        //noinspection ListRemoveInLoop - subList not implemented in My*List
        for (int i = (int) (n - 1); i >= 0; i--) {
            list.remove(i);
        }
        s.tocAndPrint("Remove by index from end");

        list.clear();
        s.tic();
        for (long i = 0; i < n; i++) {
            list.add(list.size() / 2, i);
        }
        s.tocAndPrint("Insert in the middle");

        s.tic();
        for (long i = 0; i < n; i++) {
            list.remove(i);
        }
        s.tocAndPrint("Remove by object");

        System.out.println("--------");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        List<Long>[] lists = new List[]{
                new MyArrayList<>(),
                new ArrayList<>(),
                new MyLinkedList<>(),
                new LinkedList<>()
        };
        for (int n = 100; n <= 10_000; n *= 10) {
            for (List<Long> list : lists) {
                measure(list, n);
            }
        }
    }
}
