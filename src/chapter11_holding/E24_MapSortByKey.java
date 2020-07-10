/*
Fill a LinkedHashMap with String keys and objects of your choice. Now extract
the pairs, sort them based on the keys, and reinsert them into the Map.
 */

package chapter11_holding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

class Account {
    private static int count = 0;
    final String accountCode;
    final int accountId;

    Account(String code) {
        this.accountCode = code;
        this.accountId = ++count;
    }
}

public class E24_MapSortByKey {
    public static void main(String[] args) {
        // Fill a LinkedHashMap with String keys and objects of your choice.
        Map<String, Account> accountCodeToAccountMap = new LinkedHashMap<>();
        Random random = new Random(10);
        for (int i = 0; i < 20; i++) {
            Account newAccount = new Account(i + random.nextInt(100000) + "ADT");
            accountCodeToAccountMap.put(newAccount.accountCode, newAccount);
        }

        System.out.println(accountCodeToAccountMap);

        // Now extract the pairs...
        Map<String, Account> tempMap = new LinkedHashMap<>(accountCodeToAccountMap);
        String[] keys = accountCodeToAccountMap.keySet().toArray(new String[0]);
        // ... sort them based on the keys...
        Arrays.sort(keys);
        accountCodeToAccountMap.clear();
        // ... and reinsert them into the Map.
        for (String key : keys) {
            Account tempAccount = tempMap.get(key);
            accountCodeToAccountMap.put(key, tempAccount);
        }

        System.out.println(accountCodeToAccountMap);
    }
}