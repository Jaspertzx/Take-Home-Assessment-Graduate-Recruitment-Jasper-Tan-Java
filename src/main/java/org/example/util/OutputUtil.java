package org.example.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Utilities class for handling output operations.
 * This class is created for future logging purposes and provides a central point
 * for managing how messages are printed in the application.
 */
public final class OutputUtil {

    /**
     * Is a Private constructor to prevent instantiation of this utility class.
     */
    private OutputUtil() {
        // Prevents instantiation
    }

    /**
     * Prints a system message to the standard output without a newline.
     * This method can be used for inline messages or logs.
     *
     * @param message the message to be printed.
     */
    public static void systemPrint(String message) {
        if (isVerboseMode()) {
            System.out.println(message);
        }
    }

    /**
     * Prints a system message to get user part.
     *
     * @param message the message to be printed.
     */
    public static void partPromptPrint(String message) {
        System.out.println(message);
    }

    /**
     * Prints a result message for the user.
     * This can be logged to track algorithm output consistently.
     *
     * @param message the message to be printed.
     */
    public static void resultPrint(String message) {
        System.out.println("==========");
        System.out.println("Result: ");
        System.out.print(message);
        System.out.println("==========");
    }

    /**
     * Reads the "verboseSetting" file to determine if verbose mode should be enabled.
     * If the file contains "true", returns true. If the file contains "false", if the file
     * is missing, or if it contains anything else, returns false.
     *
     * @return true if verbose mode should be enabled, false otherwise.
     */
    private static boolean isVerboseMode() {
        File file = new File("src/main/java/org/example/VerboseSetting.txt");
        boolean verbose = false;

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                String setting = scanner.nextLine().trim();
                verbose = "true".equalsIgnoreCase(setting);
            }
        } catch (FileNotFoundException e) {
            verbose = false;
        }

        return verbose;
    }
}
