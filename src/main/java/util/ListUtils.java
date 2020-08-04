package util;

import java.util.List;

public class ListUtils {
    /**
     * Adds numbers from 0 (inclusive) to {@code n} (exclusive) to the given list
     *
     * @param list list to add elements to
     * @param n    amount of elements to add
     */
    static void populate(List<Long> list, long n) {
        for (long i = 0; i < n; i++) {
            list.add(i);
        }
    }
}
