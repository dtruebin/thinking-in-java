package chapter4_control;

public class E20_IfElse {
    static int test(int testval, int target) {
        //noinspection UseCompareMethod
        if (testval > target)
            return +1;
        else if (testval < target)
            return -1;
        else
            return 0; // Одинаковые значения
    }

    static int test(int testval, int begin, int end) {
        if (testval >= end)
            return +1;
        else if (testval <= begin)
            return -1;
        else
            return 0; // Одинаковые значения
    }

    public static void main(String[] args) {
        System.out.println(test(10, 0, 5));
        System.out.println(test(5, 10, 20));
        System.out.println(test(5, 0, 10));
    }
}