/*
Modify Exercise 3 so that the catch clause logs the results.
 */

package main.java.chapter12_exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

@SuppressWarnings({"MismatchedReadAndWriteOfArray", "ConstantConditions"})
public class E07_Logging {
    static Logger logger = Logger.getLogger("E07_Logging");

    static void logException(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }

    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            System.out.println(array[10]);
        } catch (Exception e) {
            logException(e);
        }
    }
}
