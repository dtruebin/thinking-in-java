package icu.trub.tij.chapter11_holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SequenceIterable {
    private final List<Object> items = new ArrayList<>();

    public void add(Object x) {
        items.add(x);
    }

    public Iterator<Object> iterator() {
        return items.iterator();
    }
}

public class E09_SequenceIterable {
    public static void main(String[] args) {
        SequenceIterable sequence = new SequenceIterable();
        for (int i = 0; i < 10; i++) sequence.add(Integer.toString(i));

        Iterator<Object> it = sequence.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}