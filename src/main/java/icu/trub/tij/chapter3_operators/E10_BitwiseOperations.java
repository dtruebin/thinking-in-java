package icu.trub.tij.chapter3_operators;

public class E10_BitwiseOperations {
    public static void main(String[] args) {
        final short const1 = 0xAAA;
        final short const2 = 0x555;

        System.out.println(Integer.toBinaryString(const1));
        System.out.println(Integer.toBinaryString(const2));

        System.out.println("AND : " + Integer.toBinaryString(const1 & const2));
        System.out.println("OR  : " + Integer.toBinaryString(const1 | const2));
        System.out.println("XOR : " + Integer.toBinaryString(const1 ^ const2));

        String testPrimitive = "" + 1;
        String testBoxed = Integer.toString(1);
    }
}
