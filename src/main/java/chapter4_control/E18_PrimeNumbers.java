package main.java.chapter4_control;

public class E18_PrimeNumbers {
    static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int max = 100;
        // Get the max value from the command line,
        // if the argument has been provided:
        if (args.length != 0)
            max = Integer.parseInt(args[0]);
        for (int i = 1; i < max; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
