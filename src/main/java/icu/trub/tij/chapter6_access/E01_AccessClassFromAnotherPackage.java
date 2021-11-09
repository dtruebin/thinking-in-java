package icu.trub.tij.chapter6_access;

import icu.trub.tij.chapter5_initialization.E21_Enum;

import static icu.trub.util.Print.print;
import static icu.trub.util.Print.printnb;
import static icu.trub.util.Range.range;

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
