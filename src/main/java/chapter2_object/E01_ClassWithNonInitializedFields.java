package chapter2_object;

public class E01_ClassWithNonInitializedFields {
    int i;
    char c;

    public static void main(String[] args) {
        E01_ClassWithNonInitializedFields o = new E01_ClassWithNonInitializedFields();
        System.out.println("i: " + o.i + "; c: " + o.c);
    }
}
