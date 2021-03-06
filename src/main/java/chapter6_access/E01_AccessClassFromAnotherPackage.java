package chapter6_access;

import chapter5_initialization.E21_Enum;

import static util.Print.print;
import static util.Print.printnb;
import static util.Range.range;

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
