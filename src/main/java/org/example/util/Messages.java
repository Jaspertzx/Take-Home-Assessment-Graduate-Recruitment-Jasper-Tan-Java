package org.example.util;

/**
 * Utilities class that provides a centralized location for all static string constants used
 * throughout the application. These constants are used for user interface prompts and
 * error messages, ensuring consistency and ease of maintenance.
 * This class is final and cannot be instantiated.
 */
public final class Messages {

    private Messages() {}

    // Part Selection Messages
    public static final String PART_SELECTION_PROMPT = "Select part to execute (1 for Part 1, 2 for Part 2, "
            + "0 to Exit): ";
    public static final String PART_SELECTION_INVALID_VALUE_ERROR = "Invalid input. Please enter 1 for Part 1, "
            + "2 for Part 2, or 0 to Exit.";
    public static final String PART_SELECTION_NO_VALUE_ERROR = "No input provided. Exiting.";
    public static final String PART_SELECTION_NO_LINE_ERROR = "No line found. Exiting.";

    // readBoardDimensions Messages
    public static final String READBOARDDIMENSIONS_GRID_PROMPT = "Enter the grid dimensions (e.g., 10 10): ";
    public static final String READBOARDDIMENSIONS_INPUT_LENGTH_ERROR = "Please enter exactly two values separated "
            + "by a space.";
    public static final String READBOARDDIMENSIONS_NEGATIVE_INPUT = "Grid dimensions must be positive integers.";
    public static final String READBOARDIDMENSIONS_NOT_A_NUMBER = "Invalid input. Please enter two positive "
            + "integers separated by a space.";

    // readCarDetails Messages
    public static final String READCARDETAILS_PROMPT = "Enter the car's initial position and direction "
            + "(e.g., 1 2 N): ";
    public static final String READCARDETAILS_INCORRECT_LENGTH = "Please enter exactly three values separated by "
            + "spaces (x y direction).";
    public static final String READCARDETAILS_CAR_OUT_OF_BOUNDS = "Initial position is out of bounds. Please enter "
            + "a position within the grid.";
    public static final String READCARDETAILS_NOT_A_NUMBER = "Invalid position. Please enter two integers for the "
            + "position.";
    public static final String READCARDETAILS_DIRECTION_INVALID = "Invalid direction. Please enter one of the "
            + "following: N, E, S, W.";

    // readCarInstructions Messages
    public static final String READCARINSTRUCTIONS_PROMPT = "Enter the command sequence (e.g., FFRFFFFRL): ";
    public static final String READCARINSTRUCTIONS_INVALID_COMMAND = "Instructions can only contain F, "
            + "R and L characters.";

    // skipOneLineAndReadCarName Messages
    public static final String SKIPONELINEANDREADCARNAME_EMPTYLINE_PROMPT = "Please press enter to continue: ";
    public static final String SKIPONELINEANDREADCARNAME_PROMPT = "Enter the car name to add a car, otherwise you "
            + "may enter an empty line to simulate: ";
}
