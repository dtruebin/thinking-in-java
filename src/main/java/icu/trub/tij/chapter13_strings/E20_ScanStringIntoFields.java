/*
Create a class that contains int, long, float and double and String fields.
Create a constructor for this class that takes a single String argument, and
scans that string into the various fields. Add a toString( ) method and
demonstrate that your class works correctly.
 */

package icu.trub.tij.chapter13_strings;

import java.util.Scanner;

class Container {
    private final int i;
    private final long l;
    private final float f;
    private final double d;
    private final String s;

    Container(String stringWithIntLongFloatDoubleString) {
        Scanner scn = new Scanner(stringWithIntLongFloatDoubleString);
        i = scn.nextInt();
        l = scn.nextLong();
        f = scn.nextFloat();
        d = scn.nextDouble();
        s = scn.useDelimiter("$").next(".*").trim();
    }

    @Override
    public String toString() {
        return "Container{" + "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}

public class E20_ScanStringIntoFields {
    public static void main(String[] args) {
        Container c = new Container("1 2 3 4 five six");
        System.out.println(c);
    }
}
