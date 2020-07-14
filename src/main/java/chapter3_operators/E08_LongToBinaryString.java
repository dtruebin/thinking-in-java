package main.java.chapter3_operators;

public class E08_LongToBinaryString {
    public static void main(String[] args) {
        long notSoLong;

        notSoLong = 0x11;
        System.out.println(notSoLong + " == " + Long.toBinaryString(notSoLong));

        //noinspection OctalInteger
        notSoLong = 011;
        System.out.println(notSoLong + " == " + Long.toBinaryString(notSoLong));
    }
}
