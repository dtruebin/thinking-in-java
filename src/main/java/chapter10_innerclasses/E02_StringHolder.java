package main.java.chapter10_innerclasses;

class StringHolder {
    String content;

    StringHolder(String c) {
        content = c;
    }

    @Override
    public String toString() {
        return content;
    }
}

public class E02_StringHolder {
    public static void main(String[] args) {
        Sequence seq = new Sequence(5);
        for (int i = 0; i < 5; i++) {
            seq.add(new StringHolder(String.valueOf(i)));
        }

        Selector selector = seq.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
