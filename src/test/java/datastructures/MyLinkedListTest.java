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

    @SuppressWarnings("RedundantCollectionOperation")
    @Test
    void containsAll() {
        List<Integer> c = new LinkedList<>(Arrays.asList(-100, 2, null, 3));
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(-100);

        assertTrue(list.containsAll(c));
        assertFalse(list.containsAll(Collections.singleton(100500)));
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
    void removeNonExistentElementReturnsFalse() {
        assertFalse(list.remove(Integer.valueOf(1)));
    }

    @Test
    void removeSingleElementByIndexMakesListEmpty() {
        list.add(5);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeByIndexReturnsRemovedElement() {
        final int number = 123;
        list.add(number);
        assertEquals(number, list.remove(0));
    }

    @Test
    void removeAll() {
        list.addAll(Arrays.asList(1, 2, 2, null, 3, 4, null));
        assertFalse(list.removeAll(Collections.singleton(5)));
        assertTrue(list.removeAll(Arrays.asList(1, 2, 4, null)));
        assertEquals(list, Collections.singletonList(3));
    }

    @SuppressWarnings("ConstantConditions") // ignore null check
    @Test
    void removeAllForNullCollectionThrowsException() {
        assertThrows(NullPointerException.class, () -> list.removeAll(null));
    }

    @Test
    void retainAll() {
        list.addAll(Arrays.asList(1, 2, 2, null, 3, 4, null));
        assertTrue(list.retainAll(Arrays.asList(3, null, 1)));
        assertEquals(list, Arrays.asList(1, null, 3, null));
        assertTrue(list.retainAll(Arrays.asList(3, null)));
        assertEquals(list, Arrays.asList(null, 3, null));
    }

    @SuppressWarnings("ConstantConditions") // ignore null check
    @Test
    void retainAllForNullCollectionThrowsException() {
        assertThrows(NullPointerException.class, () -> list.retainAll(null));
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
    void addReturnsTrue() {
        assertTrue(list.add(1));
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
    void listIteratorHasPrevious() {
        list.add(0);
        ListIterator<Integer> listIterator = list.listIterator();
        assertFalse(listIterator.hasPrevious());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
    }

    @Test
    void listIteratorNextReturnsElement() {
        list.addAll(Arrays.asList(2, 4, 6));
        ListIterator<Integer> listIterator = list.listIterator();
        for (Integer element : list) {
            assertEquals(element, listIterator.next());
        }
    }

    @Test
    void listIteratorPreviousReturnsElement() {
        list.addAll(Arrays.asList(2, 4, 6));
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            assertEquals(list.get(i), listIterator.previous());
        }
    }

    @Test
    void listIteratorNoNextOrPreviousThrowsException() {
        ListIterator<Integer> listIterator = list.listIterator();
        assertThrows(NoSuchElementException.class, listIterator::previous);
        assertThrows(NoSuchElementException.class, listIterator::next);
    }

    @Test
    void listIteratorPreviousAndNextIndex() {
        list.addAll(Arrays.asList(2, 4, 6));
        ListIterator<Integer> listIterator = list.listIterator();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i - 1, listIterator.previousIndex());
            assertEquals(i, listIterator.nextIndex());
            listIterator.next();
        }
    }

    @Test
    void listIteratorPreviousReducesNextIndex() {
        list.addAll(Arrays.asList(2, 4, 6));
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        for (int i = list.size(); i > 0; i--) {
            int oldNext = listIterator.nextIndex();
            listIterator.previous();
            int newNext = listIterator.nextIndex();
            assertEquals(oldNext - 1, newNext);
        }
    }

    @Test
    void listIteratorSetWithNoMoveThrowsException() {
        ListIterator<Integer> listIterator = list.listIterator();
        assertThrows(IllegalStateException.class, () -> listIterator.set(5));
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
        assertFalse(list.addAll(Collections.emptySet()));
        assertFalse(list.addAll(0, Collections.emptySet()));
    }

    @Test
    void addAllSuccessfulReturnsTrue() {
        assertTrue(list.addAll(Collections.singleton(1)));
        assertTrue(list.addAll(0, Collections.singleton(1)));
    }

    @Test
    void addAllAtBadIndexThrowsException() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(-1, Collections.emptySet())),
                () -> assertDoesNotThrow(() -> list.addAll(0, Collections.emptySet())),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(1, Collections.emptySet()))
        );
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