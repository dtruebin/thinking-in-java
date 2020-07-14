package main.java.chapter10_innerclasses;

class E26_OuterOne {
    class InnerOne {
        InnerOne(String s) {
            System.out.println(s);
        }
    }
}

class E26_OuterTwo {
    class InnerTwo extends E26_OuterOne.InnerOne {
        InnerTwo(E26_OuterOne o, String s) {
            o.super(s);
        }
    }
}

public class E26_InnerClassInheritance {
    public static void main(String[] args) {
        E26_OuterOne o1 = new E26_OuterOne();
        E26_OuterTwo o2 = new E26_OuterTwo();
        E26_OuterTwo.InnerTwo i2 = o2.new InnerTwo(o1, "hi");
    }
}