package icu.trub.tij.chapter4_control;

public class PrimeNumbers_Compare {
    public static void main(String[] args) {
        int n = 500000;
        if (args.length != 0)
            n = Integer.parseInt(args[0]);

        // Naive
        for (int i = 100; i <= n; i *= 2) {
            long startTime = System.nanoTime();
            E18_PrimeNumbers.main(new String[]{Integer.toString(i)});
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Naive(" + i + ") ns : " + timeElapsed);
        }

        // Sieve
        for (int i = 100; i <= n; i *= 2) {
            long startTime = System.nanoTime();
            E18_PrimeNumbers_Sieve.main(new String[]{Integer.toString(i)});
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Sieve(" + i + ") ns : " + timeElapsed);
        }
    }
}
