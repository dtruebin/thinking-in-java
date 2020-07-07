/*
Fill a HashMap with key-value pairs. Print the results to show ordering by hash
code. Extract the pairs, sort by key, and place the result into a LinkedHashMap.
Show that the insertion order is maintained.
 */

package chapter11_holding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class E18_MapOrder {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Firefox", "Mozilla");
        map.put("Chrome", "Google");
        map.put("Safari", "Apple");
        map.put("Edge", "Microsoft");

        System.out.println(map);

        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        Map<String, String> sortedMap = new LinkedHashMap<>();
        for (String key : keys) {
            sortedMap.put(key, map.get(key));
        }
        System.out.println(sortedMap);
    }
}
