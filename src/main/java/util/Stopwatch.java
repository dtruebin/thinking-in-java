package util;

public class Stopwatch {
    private long startTime = System.currentTimeMillis();

    /**
     * Starts the stopwatch.
     *
     * @see #toc()
     */
    void tic() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Returns amount of time passed since last {@code tic} call.
     *
     * @return the difference, measured in milliseconds, between the current time
     * and time recorded by the last call of {@code tic} method.
     */
    long toc() {
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    void tocAndPrint(String msg) {
        System.out.println(msg + ": " + toc());
    }
}
