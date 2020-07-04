package chapter11_holding;

import java.util.ArrayList;
import java.util.List;

interface Selector {
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean end();

    Object current();

    void next();
}

class Sequence {
    private final List<Object> items;
    private final int next = 0;

    public Sequence(int size) {
        items = new ArrayList<>(size);
    }

    public void add(Object x) {
        items.add(x);
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) i++;
        }
    }

    private class ReverseSequenceSelector implements Selector {

        private int i = items.size() - 1;

        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i >= 0) i--;
        }
    }
}

public class E03_Sequence {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) sequence.add(Integer.toString(i));

        Selector selector;

        selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        System.out.println();

        selector = sequence.reverseSelector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}