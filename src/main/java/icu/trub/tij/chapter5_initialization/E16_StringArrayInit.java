package icu.trub.tij.chapter5_initialization;

import java.util.Arrays;

/**
 * Создайте массив объектов String. Присвойте объект String каждому элементу. Выведите содержимое массива в цикле for.
 */
public class E16_StringArrayInit {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"one", "two", "three"};
        for (String str :
                stringArray) {
            System.out.println(str);
        }
        System.out.println(Arrays.toString(stringArray));
    }
}
