package main.java.chapter11_holding;

import java.util.ArrayList;
import java.util.List;

class Gerbil {
    private static int counter;
    int gerbilNumber;

    Gerbil() {
        gerbilNumber = counter++;
    }

    void hop() {
        System.out.println("Gerbil #" + gerbilNumber + " is hopping");
    }
}

public class E01_GerbilHopping {
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
