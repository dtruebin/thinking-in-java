package icu.trub.tij.chapter10_innerclasses;

class E05Outer {
    class E05Inner {
        {
            System.out.println("E05Inner created");
        }
    }
}

public class E05_DotNew {
    public static void main(String[] args) {
        E05Outer.E05Inner inner = new E05Outer().new E05Inner();
    }
}
