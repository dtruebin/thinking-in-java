package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add(null);
        assertEquals(1, list.size());
        list.add(null);
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(null);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void clear() {
        list.clear();
        assertTrue(list.isEmpty());

        list.add(null);
        list.add(null);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(list.contains(3));
        list.add(3);
        assertTrue(list.contains(3));
    }

    @Test
    void toArrayOfObject() {
        Object[] ref = {3, 6, 9};
        list.add(3);
        list.add(6);
        list.add(9);
        Object[] fromList = list.toArray();
        assertArrayEquals(ref, fromList);
    }

    @Test
    void toArrayOfSpecifiedClass() {
        Integer[] ref = {3, 6, 9};
        list.add(3);
        list.add(6);
        list.add(9);
        Integer[] fromList = list.toArray(new Integer[0]);
        assertArrayEquals(ref, fromList);
    }

    @Test
    void removeDeletesFirstFoundObject() {
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(6);
        assertTrue(list.remove(Integer.valueOf(2)));
        assertTrue(list.remove(Integer.valueOf(3)));
        assertTrue(list.contains(0));
        assertFalse(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(6));
    }
}