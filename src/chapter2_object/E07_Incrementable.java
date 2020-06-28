package chapter2_object;

@SuppressWarnings("unused")
public class E07_Incrementable {

    static void increment() {
        StaticTest.i++;
    }

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();

        System.out.println(StaticTest.i + " == " + StaticTest.i);

        StaticTest.i++;
        StaticTest.i++;

        System.out.println(StaticTest.i + " == " + StaticTest.i);
    }
}


class StaticTest {
    static int i = 47;
}