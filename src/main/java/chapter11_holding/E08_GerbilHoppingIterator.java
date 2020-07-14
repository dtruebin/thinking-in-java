package main.java.chapter11_holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class E08_GerbilHoppingIterator {
    public static void main(String[] args) {
        List<Gerbil> gerbilList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            gerbilList.add(new Gerbil());
        }

        Iterator<Gerbil> it = gerbilList.iterator();
        //noinspection WhileLoopReplaceableByForEach
        while (it.hasNext()) {
            it.next().hop();
        }
    }
}