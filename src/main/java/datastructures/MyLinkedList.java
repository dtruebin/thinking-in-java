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
    public boolean contains(Object o) {// TODO
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public Object[] toArray() {// TODO
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {// TODO
        return null;
    }

    @Override
    public boolean add(E e) {
        append(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {// TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {// TODO
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {// TODO
        return false;
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

    @Override
    public E set(int index, E element) {// TODO
        return null;
    }

    @Override
    public void add(int index, E element) {// TODO

    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToBeRemoved = getNode(index);
        Node<E> nodeNext = nodeToBeRemoved.next;
        Node<E> nodePrev = nodeToBeRemoved.prev;

        if (size() == 1) {
            head = tail = null;
        } else if (nodeToBeRemoved == head) {
            nodeToBeRemoved.next = null;
            nodeNext.prev = null;
            head = nodeNext;
        } else if (nodeToBeRemoved == tail) {
            nodeToBeRemoved.prev = null;
            nodePrev.next = null;
            tail = nodePrev;
        } else {
            nodePrev.next = nodeToBeRemoved.next;
            nodeNext.prev = nodeToBeRemoved.prev;
        }
        size--;

        return nodeToBeRemoved.item;
    }

    @Override
    public int indexOf(Object o) {// TODO
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {// TODO
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {// TODO
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {// TODO
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {// TODO
        return null;
    }

    private void append(E item) {
        Node<E> newNode = new Node<>(item, tail, null);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        size++;
    }

    private void prepend(E item) {
        Node<E> newNode = new Node<>(item, null, head);
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
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

    private class Iter implements Iterator<E> {

        /**
         * Index of element that will be returned by call to next.
         */
        private int cursor = 0;

        /**
         * Index of element that was returned by the last call to next.
         */
        private int lastReturned = -1;

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
