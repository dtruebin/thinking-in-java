package datastructures;

import java.util.*;

public class MyLinkedList<E> implements List<E> {
    private Node<E> head, tail;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return getNode(o) != null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size());
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (e.equals(o)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {// TODO
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {// TODO
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {// TODO
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {// TODO
        return false;
    }

    @Override
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E set(int index, E element) { // TODO
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (!isIndexInRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size()) {
            linkFirst(element);
        } else {
            linkBefore(element, getNode(index));
        }
    }

    private boolean isIndexInRange(int index) {
        return index >= 0 && index <= size();
    }

    private Node<E> getNode(int index) {
        Node<E> resultNode = head;

        if ((index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            resultNode = resultNode.next;
        }

        return resultNode;
    }

    private Node<E> getNode(Object o) {
        Node<E> resultNode = head;

        for (int i = 0; i < size(); i++, resultNode = resultNode.next) {
            if (resultNode.item.equals(o)) {
                return resultNode;
            }
        }

        return null;
    }

    private E unlink(Node<E> node) {
        E element = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return unlink(getNode(index));
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        if (o == null) {
            for (Node<E> current = head; current != null; current = current.next, i++) {
                if (current.item == null) {
                    return i;
                }
            }
        } else {
            for (Node<E> current = head; current != null; current = current.next, i++) {
                if (o.equals(current.item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {// TODO
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIter(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {// TODO
        return null;
    }

    private void linkFirst(E item) {
        Node<E> newNode = new Node<>(item, null, head);
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    private void linkLast(E item) {
        Node<E> newNode = new Node<>(item, tail, null);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        size++;
    }

    private void linkBefore(E item, Node<E> next) {
        Node<E> newNode = new Node<>(item, next.prev, next);
        if (next == head) {
            head = newNode;
        } else {
            next.prev.next = newNode;
        }
        next.prev = newNode;
        size++;
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();

        if (!it.hasNext()) {
            return "[]";
        }

        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            E e = it.next();
            sb.append(e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Iterator<E> itThis = iterator();
        Iterator<?> itThat = ((List<?>) o).iterator();

        while (itThis.hasNext() && itThat.hasNext()) {
            E elThis = itThis.next();
            Object elThat = itThat.next();

            if (!(Objects.equals(elThis, elThat))) {
                return false;
            }
        }

        return !(itThis.hasNext() || itThat.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (E e : this)
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        return hashCode;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class ListIter implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        ListIter(int index) {
            next = (index == size()) ? null : getNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            next = (next == null) ? tail : next.prev;
            lastReturned = next;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.item = e;
        }

        @Override
        public void add(E e) {
            if (next == null) {
                linkLast(e);
            } else {
                linkBefore(e, next);
            }
            nextIndex++;
        }
    }

    private class Iter implements Iterator<E> {

        /**
         * Index of element that will be returned by call to next.
         */
        int cursor = 0;

        /**
         * Index of element that was returned by the last call to next.
         */
        int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            try {
                int i = cursor;
                E next = get(cursor);
                lastReturned = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                // next method has not yet been called
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(lastReturned);
            cursor--;
            lastReturned = -1;
        }
    }
}
