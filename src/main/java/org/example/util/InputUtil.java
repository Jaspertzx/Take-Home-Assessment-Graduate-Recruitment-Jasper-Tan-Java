package org.example.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.example.model.Board;
import org.example.model.Car;
import org.example.model.Direction;
import org.example.model.Instruction;
import org.example.model.PartSelection;

/**
 * Utilities class for handling user input operations.
 * This class provides methods to read various inputs needed for the car simulation program.
 */
public final class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Is a Private constructor to prevent instantiation of this utility class.
     */
    private InputUtil() {
        // Prevents instantiation
    }

    /**
     * Reads the user's choice for Part 1, Part 2, or Exit.
     *
     * @return a {@link PartSelection} enum value representing the user's choice.
     */
    public static PartSelection readPartSelection() {
        OutputUtil.partPromptPrint(Messages.PART_SELECTION_PROMPT);

        while (true) {
            try {
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine().trim();
                    switch (input) {
                    case "1":
                        return PartSelection.ONE;
                    case "2":
                        return PartSelection.TWO;
                    case "0":
                        return PartSelection.EXIT;
                    default:
                        OutputUtil.partPromptPrint(Messages.PART_SELECTION_INVALID_VALUE_ERROR);
                    }
                } else {
                    OutputUtil.partPromptPrint(Messages.PART_SELECTION_NO_VALUE_ERROR);
                    return PartSelection.EXIT;
                }
            } catch (NoSuchElementException e) {
                OutputUtil.partPromptPrint(Messages.PART_SELECTION_NO_LINE_ERROR);
                return PartSelection.EXIT;
            }
        }
    }

    /**
     * Reads the grid dimensions (width and height) from the user.
     *
     * @return a {@link Board} object representing the grid dimensions.
     */
    public static Board readBoardDimensions() {
        int gridWidth = 0;
        int gridHeight = 0;
        while (true) {
            OutputUtil.systemPrint(Messages.READBOARDDIMENSIONS_GRID_PROMPT);
            String gridInput = scanner.nextLine();
            String[] gridDimensions = gridInput.split(" ");

            if (gridDimensions.length != 2) {
                OutputUtil.systemPrint(Messages.READBOARDDIMENSIONS_INPUT_LENGTH_ERROR);
                continue;
            }

            try {
                gridWidth = Integer.parseInt(gridDimensions[0]);
                gridHeight = Integer.parseInt(gridDimensions[1]);
                if (gridWidth > 0 && gridHeight > 0) {
                    break;
                } else {
                    OutputUtil.systemPrint(Messages.READBOARDDIMENSIONS_NEGATIVE_INPUT);
                }
            } catch (NumberFormatException e) {
                OutputUtil.systemPrint(Messages.READBOARDIDMENSIONS_NOT_A_NUMBER);
            }
        }
        return new Board(gridWidth, gridHeight);
    }

    /**
     * Skips one line and reads the car name from the next line.
     * If the next line is empty, returns null.
     *
     * @return the car name or null if the next line is empty.
     */
    public static String skipOneLineAndReadCarName() {
        OutputUtil.systemPrint(Messages.SKIPONELINEANDREADCARNAME_EMPTYLINE_PROMPT);
        scanner.nextLine();
        OutputUtil.systemPrint(Messages.SKIPONELINEANDREADCARNAME_PROMPT);

        String nextLine = scanner.nextLine().trim();
        if (nextLine.isEmpty()) {
            return null;
        }
        return nextLine;
    }

    /**
     * Reads and returns the car's initial position and direction from the user.
     * Validates the input to ensure that the position is within the grid bounds and that the direction is valid.
     *
     * @param board the {@link Board} object representing the grid.
     * @param carName the name of the car.
     * @return a {@link Car} object initialized with the user-provided details.
     */
    public static Car readCarDetails(Board board, String carName) {
        int initialX = 0;
        int initialY = 0;
        Direction initialDirection = null;
        while (true) {
            OutputUtil.systemPrint(Messages.READCARDETAILS_PROMPT);
            String positionInput = scanner.nextLine();
            String[] positionDetails = positionInput.split(" ");

            if (positionDetails.length != 3) {
                OutputUtil.systemPrint(Messages.READCARDETAILS_INCORRECT_LENGTH);
                continue;
            }

            try {
                initialX = Integer.parseInt(positionDetails[0]);
                initialY = Integer.parseInt(positionDetails[1]);
                initialDirection = Direction.fromString(positionDetails[2]);
                if (board.isWithinBounds(initialX, initialY)) {
                    break;
                } else {
                    OutputUtil.systemPrint(Messages.READCARDETAILS_CAR_OUT_OF_BOUNDS);
                }
            } catch (NumberFormatException e) {
                OutputUtil.systemPrint(Messages.READCARDETAILS_NOT_A_NUMBER);
            } catch (IllegalArgumentException e) {
                OutputUtil.systemPrint(Messages.READCARDETAILS_DIRECTION_INVALID);
            }
        }

        if (carName.isEmpty()) {
            return new Car(initialX, initialY, initialDirection);
        }
        return new Car(carName, initialX, initialY, initialDirection);
    }

    /**
     * Prompts the user to enter a sequence of commands for the car.
     * Validates the command sequence to ensure it contains only 'F', 'R', and 'L' characters.
     *
     * @return an {@link Instruction} object containing the command sequence.
     */
    public static Instruction readCarInstructions() {
        String commandSequence;
        while (true) {
            OutputUtil.systemPrint(Messages.READCARINSTRUCTIONS_PROMPT);
            commandSequence = scanner.nextLine().toUpperCase();
            if (commandSequence.matches(Instruction.REGEX)) {
                break;
            } else {
                OutputUtil.systemPrint(Messages.READCARINSTRUCTIONS_INVALID_COMMAND);
            }
        }
        return new Instruction(commandSequence);
    }
}
