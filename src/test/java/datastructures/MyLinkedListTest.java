package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        assertFalse(list.contains(null));
        list.add(3);
        list.add(null);
        assertTrue(list.contains(3));
        assertTrue(list.contains(null));
    }

    @Test
    void containsAll() {
        List<Integer> c = new LinkedList<>(Arrays.asList(-100, 2, null, 3));
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(-100);

        assertTrue(list.containsAll(c));
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
        list.add(null);
        list.add(null);
        list.add(6);
        assertTrue(list.remove(Integer.valueOf(2)));
        assertTrue(list.remove(Integer.valueOf(3)));
        assertTrue(list.remove(null));
        assertTrue(list.contains(0));
        assertFalse(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(null));
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
    void addAtIndex() {
        list.add(3);
        list.add(list.indexOf(3), 1);
        list.add(list.indexOf(3), 2);
        list.add(list.size(), 4);

        List<Integer> ref = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

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
    void getFirstAndLastIndexByElement() {
        list.add(1);
        list.add(null);
        list.add(null);
        list.add(2);
        list.add(2);

        assertEquals(0, list.indexOf(1));
        assertEquals(3, list.indexOf(2));
        assertEquals(1, list.indexOf(null));
        assertEquals(-1, list.indexOf(100));

        assertEquals(0, list.lastIndexOf(1));
        assertEquals(4, list.lastIndexOf(2));
        assertEquals(2, list.lastIndexOf(null));
        assertEquals(-1, list.lastIndexOf(100));
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

    @Test
    void addAllAtIndex() {
        Set<Integer> c = new LinkedHashSet<>(Arrays.asList(1, null, 2));
        list.add(3);
        list.add(4);
        list.addAll(0, c);
        list.addAll(list.size(), c);
        assertEquals(list, Arrays.asList(1, null, 2, 3, 4, 1, null, 2));
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