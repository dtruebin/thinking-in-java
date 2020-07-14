package main.java.chapter10_innerclasses;

interface Selector {
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private final Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) sequence.add(Integer.toString(i));

        Selector selector;

        // E16
//        selector = sequence.selector();

        // E20
        selector = sequence.reverseSelector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        System.out.println(sequence.check());
    }

    // E04
    boolean check() {
        return this == ((SequenceSelector) selector()).getSequence();
    }

    public void add(Object x) {
        if (next < items.length) items[next++] = x;
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }

        // E04
        public Sequence getSequence() {
            return Sequence.this;
        }
    }

    /**
     * E20
     */
    private class ReverseSequenceSelector implements Selector {

        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0) i--;
        }
    }
}