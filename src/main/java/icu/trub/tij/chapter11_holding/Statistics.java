package icu.trub.tij.chapter11_holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10_000; i++) {
            int n = rand.nextInt(20);
            Integer freq = map.get(n);
            map.put(n, freq == null ? 1 : freq + 1);
        }

        System.out.println(map);
    }
}