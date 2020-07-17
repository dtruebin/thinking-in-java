package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private static final Integer[] arr = {1, 2, 3, null, 5, 5};
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>(arr);
    }

    @Test
    void contains() {
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(null));
        assertTrue(list.contains(5));
        assertFalse(list.contains(-10));
        assertFalse(list.contains(100));
    }

    @Test
    void toArray() {
        assertArrayEquals(arr, list.toArray());
        assertArrayEquals(arr, list.toArray(new Integer[0]));

        Integer[] arrBiggerThanListSize = new Integer[10];
        Arrays.fill(arrBiggerThanListSize, 100);
        Integer[] arrExpected = new Integer[]{1, 2, 3, null, 5, 5, null, 100, 100, 100};
        assertArrayEquals(arrExpected, list.toArray(arrBiggerThanListSize));

        //noinspection ConstantConditions
        assertThrows(NullPointerException.class, () -> list.toArray(null));
    }

    @Test
    void clear() {
        assertFalse(list.isEmpty());
        list.clear();
        //noinspection ConstantConditions
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[0], list.toArray());
    }

    @SuppressWarnings({"SimplifiableAssertion", "ResultOfMethodCallIgnored"})
    @Test
    void get() {
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(null, list.get(3));
        assertEquals(5, list.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
    }

    @Test
    void set() {
        assertEquals(list.get(0), list.set(0, 10));
        assertEquals(10, list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(list.size(), 100));
    }

    @Test
    void remove() {
        Integer prevHead = list.get(1);
        assertEquals(list.get(0), list.remove(0));
        assertEquals(prevHead, list.get(0));

        Integer prevPenultimate = list.get(list.size() - 2);
        assertEquals(list.get(list.size() - 1), list.remove(list.size() - 1));
        assertEquals(prevPenultimate, list.get(list.size() - 1));

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
    }

    @Test
    void indexOf() {
        assertEquals(0, list.indexOf(1));
        assertEquals(3, list.indexOf(null));
        assertEquals(4, list.indexOf(5));
        assertEquals(-1, list.indexOf(100));
    }

    @Test
    void lastIndexOf() {
        assertEquals(3, list.indexOf(null));
        assertEquals(5, list.lastIndexOf(5));
    }
}