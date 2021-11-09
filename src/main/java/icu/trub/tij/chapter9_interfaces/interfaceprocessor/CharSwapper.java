package icu.trub.tij.chapter9_interfaces.interfaceprocessor;

public class CharSwapper {
    static String swap(String s) {
        char[] c = s.toCharArray();

        for (int i = 1; i < s.length(); i += 2) {
            char temp = c[i];
            c[i] = c[i - 1];
            c[i - 1] = temp;
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(swap("abcdef"));
        System.out.println(swap("abcdefg"));
    }
}
