package util;

import datastructures.MyArrayList;
import datastructures.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static util.ListUtils.populate;

public class ListPerformanceTest {
    static Stopwatch s = new Stopwatch();

    // TODO make tic-do-toc part reusable. Method taking another method as
    //  parameter? Lambdas?
    // TODO figure out a better way to store/present the measured results
    // TODO print heading only once
    // TODO check if it's beneficial to switch from StringBuilder to StringJoiner

    /**
     * Measures total duration of {@code n} executions for each of the various
     * List operations, and prints the result in a CSV-like format.
     *
     * @param refList list to use as reference: its class is used to build a new
     *                "guinea pig" list
     * @param n       number of operations to execute
     */
    static void measure(List<Long> refList, long n) {
        List<Long> list;
        StringBuilder sbResult = new StringBuilder();
        StringBuilder sbHeading = new StringBuilder();
        try {
            //noinspection unchecked
            list = refList.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Measuring performance of " + list.getClass().getName() + " with " + n + " elements");

        sbHeading.append("Class,N,");
        sbResult.append(list.getClass().getName())
                .append(",")
                .append(n)
                .append(",");

        sbHeading.append("Append,");
        s.tic();
        for (long i = 0; i < n; i++) {
            list.add(i);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.append("Get by index,");
        s.tic();
        for (long i = 0; i < n; i++) {
            //noinspection ResultOfMethodCallIgnored - no need to store it
            list.get((int) i);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.append("Remove by index from beginning,");
        s.tic();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.append("Remove by index from end,");
        populate(list, n);
        s.tic();
        //noinspection ListRemoveInLoop - subList not implemented in My*List
        for (int i = (int) (n - 1); i >= 0; i--) {
            list.remove(i);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.append("Insert in the middle,");
        list.clear();
        s.tic();
        for (long i = 0; i < n; i++) {
            list.add(list.size() / 2, i);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.append("Remove by object,");
        s.tic();
        for (long i = 0; i < n; i++) {
            list.remove(i);
        }
        sbResult.append(s.toc()).append(",");

        sbHeading.deleteCharAt(sbHeading.length() - 1);
        sbResult.deleteCharAt(sbResult.length() - 1);
        System.out.println(sbHeading);
        System.out.println(sbResult);
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        List<Long>[] lists = new List[]{
                new MyArrayList<>(),
                new ArrayList<>(),
                new MyLinkedList<>(),
                new LinkedList<>()
        };

        int total = 100_000;
        if (args.length > 0) {
            try {
                total = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.format(
                        "\"%s\" can't be parsed to int. Using default total: %d\n",
                        args[0], total
                );
            }
        }

        for (List<Long> list : lists) {
            for (int n = 10000; n <= total; n += 10000) {
                measure(list, n);
            }
        }
    }
}
