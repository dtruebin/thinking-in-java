package datastructures;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] data;
    private int size = 0; // not to be confused with capacity

    MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    MyArrayList(E[] array) {
        this.data = array.clone();
        this.size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size());
        }
        Object[] result = a;
        System.arraycopy(data, 0, result, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndexInRange(index);
        return (E) data[index];
    }

    private void checkIndexInRange(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        E previousElement = get(index);
        data[index] = element;
        return previousElement;
    }

    @Override
    public E remove(int index) {
        E previousElement = get(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        return previousElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, data[i])) {
                return i;
            }
        }
        return -1;
    }
}
