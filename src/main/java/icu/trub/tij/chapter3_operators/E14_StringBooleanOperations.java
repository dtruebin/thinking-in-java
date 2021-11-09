package icu.trub.tij.chapter3_operators;

public class E14_StringBooleanOperations {

    @SuppressWarnings("StringEquality")
    static void testStringBooleanOperations(String str1, String str2) {
        System.out.println("Strings: \"" + str1 + "\" and \"" + str2 + "\"");
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);
        System.out.println(str1.equals(str2));

    }

    public static void main(String[] args) {
        testStringBooleanOperations("abc", "abc");
        testStringBooleanOperations("abc", "def");
    }
}
