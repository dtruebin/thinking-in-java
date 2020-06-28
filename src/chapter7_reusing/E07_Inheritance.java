package chapter7_reusing;

class A7 {
    A7(String msg) {
        System.out.println("Constructing A: " + msg);
    }
}

class B7 {
    B7(String msg) {
        System.out.println("Constructing B: " + msg);
    }
}

class C7 extends A7 {
    B7 b7;

    C7(String msg) {
        super(msg);
        b7 = new B7(msg);
    }


}

public class E07_Inheritance {
    public static void main(String[] args) {
        new C7("Hey!");
    }
}
