package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private static final Integer[] arr = {1, 2, 3, null, 5, 5};
    private static final Random rand = new Random();
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
    void iteratorStopsAtLastAndThrowsExceptionAfterwards() {
        Integer element = null;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            element = it.next();
        }
        assertEquals(list.get(list.size() - 1), element);
        assertThrows(NoSuchElementException.class, it::next);
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
    void add() {
        int lastSize = list.size();
        int value = rand.nextInt();
        assertTrue(list.add(value));
        assertEquals(value, list.get(lastSize));
        assertEquals(lastSize + 1, list.size());
    }

    @Test
    void clear() {
        assertFalse(list.isEmpty());
        list.clear();
        //noinspection ConstantConditions
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[0], list.toArray());
    }

    @SuppressWarnings({"SimplifiableAssertion"})
    @Test
    void get() {
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(null, list.get(3));
        assertEquals(5, list.get(4));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void getAtBadIndexThrowsException() {
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
    void removeObject() {
        assertTrue(list.remove((Integer) 3));
        assertFalse(list.remove((Integer) 3));
        assertTrue(list.remove(null));
        assertTrue(list.remove((Integer) 5));

        Integer[] arrExpected = {1, 2, 5};
        assertArrayEquals(arrExpected, list.toArray(new Integer[0]));
    }

    @Test
    void addAtIndexFirst() {
        int value = rand.nextInt();
        Integer oldFirst = list.get(0);

        list.add(0, value);

        assertEquals(value, list.get(0));
        assertEquals(oldFirst, list.get(1));
    }

    @Test
    void addAtIndexMiddle() {
        int value = rand.nextInt();
        int sizeAtStart = list.size();
        Integer oldMiddle = list.get(sizeAtStart / 2);

        list.add(sizeAtStart / 2, value);

        assertEquals(value, list.get(sizeAtStart / 2));
        assertEquals(oldMiddle, list.get(sizeAtStart / 2 + 1));
    }

    @Test
    void addAtIndexLast() {
        int value = rand.nextInt();
        int sizeAtStart = list.size();
        Integer oldLast = list.get(sizeAtStart - 1);

        list.add(sizeAtStart, value);

        assertEquals(oldLast, list.get(list.size() - 2));
        assertEquals(value, list.get(list.size() - 1));
    }

    @Test
    void addAtIndexSecondToLast() {
        int value = rand.nextInt();
        int sizeAtStart = list.size();
        Integer oldLast = list.get(sizeAtStart - 1);

        list.add(sizeAtStart - 1, value);

        assertEquals(value, list.get(list.size() - 2));
        assertEquals(oldLast, list.get(list.size() - 1));
    }

    @Test
    void addAtBadIndexThrowsException() {
        int value = rand.nextInt();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, value));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size() + 1, value));
    }

    @Test
    void removeAtIndexFirst() {
        int initialSize = list.size();
        Integer headToBe = list.get(1);
        assertEquals(list.get(0), list.remove(0));
        assertEquals(headToBe, list.get(0));
        assertEquals(initialSize - 1, list.size());
    }

    @Test
    void removeAtIndexLast() {
        int initialSize = list.size();
        int removeIndex = initialSize - 1;
        Integer tailToBe = list.get(initialSize - 2);
        assertEquals(list.get(removeIndex), list.remove(removeIndex));
        assertEquals(tailToBe, list.get(list.size() - 1));
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