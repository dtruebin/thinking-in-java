package icu.trub.tij.chapter5_initialization;

/**
 * Create a class with a String that is initialized using "instance initialization".
 */
public class E15_StringChildInit {
    String str;

    {
        str = "hello";
        System.out.println(str);
    }

    public static void main(String[] args) {
        new E15_StringChildInit();
    }
}