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
}