package main.java.chapter6_access;

import main.java.chapter5_initialization.E21_Enum;

import static main.java.util.Print.print;
import static main.java.util.Print.printnb;
import static main.java.util.Range.range;

public class E01_AccessClassFromAnotherPackage {
    public static void main(String[] args) {
        E21_Enum e = new E21_Enum();
        E21_Enum.Currency c = E21_Enum.Currency.DOLLAR;
        print(c.name());

        for (int i :
                range(20)) {
            printnb(i + " ");
        }
    }
}
