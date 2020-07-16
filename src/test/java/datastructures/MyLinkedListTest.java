package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private List<Integer> list;

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
    void removeByObjectDeletesFirstFoundObject() {
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

    @Test
    void removeSingleNodeMakesListEmpty() {
        list.add(5);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeByListIterator() {
        list.add(0);
        list.add(3);
        list.add(6);
        ListIterator<Integer> it = list.listIterator(1);
        it.next();
        it.remove();
        assertFalse(list.contains(3));
        it.next();
        it.remove();
        assertFalse(list.contains(6));
        it.previous();
        it.remove();
        assertFalse(list.contains(0));
    }

    @Test
    void testAddAtIndex() {
        list.add(3);
        list.add(list.indexOf(3), 1);
        list.add(list.indexOf(3), 2);

        MyLinkedList<Integer> ref = new MyLinkedList<>();
        ref.add(1);
        ref.add(2);
        ref.add(3);

        assertEquals(list, ref);
    }

    @Test
    void addToEmptyListAtPositionZero() {
        list.add(0, null);
    }

    @Test
    void addAtBadPositionThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, null));
    }

    @Test
    void addFromListIteratorToEmptyList() {
        ListIterator<Integer> it = list.listIterator();
        it.add(1);
        assertTrue(list.contains(1));
    }

    @Test
    void addFromListIteratorToListEndDoesNotMoveExplicitCursor() {
        list.add(0);
        ListIterator<Integer> it = list.listIterator();
        it.next();
        it.add(1);
        assertTrue(list.contains(1));
        assertFalse(it.hasNext());
    }

    @Test
    void indexOf() {
        list.add(1);
        list.add(2);
        list.add(null);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
        assertEquals(2, list.indexOf(null));
    }

    @Test
    void addAllForEmptyCollectionReturnsFalse() {
        Set<Integer> c = new HashSet<>();
        assertFalse(list.addAll(c));
    }

    @SuppressWarnings("UseBulkOperation")
    @Test
    void addAllResultMatchesMultipleAdd() {
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }

        list.addAll(c);
        List<Integer> listFilledWithMultipleAdd = new MyLinkedList<>();
        for (Integer i : c) {
            listFilledWithMultipleAdd.add(i);
        }

        assertEquals(list, listFilledWithMultipleAdd);
    }

    @SuppressWarnings("SimplifiableJUnitAssertion") // for the  sake of uniformity
    @Test
    void setReplacesElementAndReturnsPrevious() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.set(1, null));
        assertEquals(null, list.set(1, 10));
        assertEquals(10, list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(100, null));
    }
}