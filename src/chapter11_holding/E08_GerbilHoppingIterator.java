package chapter11_holding;

import java.util.ArrayList;
import java.util.List;

public class E08_GerbilHoppingIterator {
    public static void main(String[] args) {
        List<Gerbil> gerbilList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            gerbilList.add(new Gerbil());
        }

        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < gerbilList.size(); i++) {
            gerbilList.get(i).hop();
        }
    }
}