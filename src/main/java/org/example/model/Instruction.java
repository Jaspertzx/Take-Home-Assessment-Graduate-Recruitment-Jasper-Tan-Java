package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sequence of commands that can be executed by a car.
 * The commands are stored as a list of characters and are executed sequentially.
 */
public class Instruction {

    public static final String REGEX = "[FRL]+";
    private final List<Character> commandList;
    private int currentCommandIndex;

    /**
     * Constructs an Instruction object from a command sequence string.
     * The command sequence can contain 'L' (turn left), 'R' (turn right), and 'F' (move forward).
     *
     * @param commandSequence the sequence of commands to be executed.
     * @throws IllegalArgumentException if the command sequence contains invalid characters.
     */
    public Instruction(String commandSequence) {
        this.currentCommandIndex = 0;
        this.commandList = new ArrayList<>();
        for (char command : commandSequence.toCharArray()) {
            if (isValidCommand(command)) {
                commandList.add(command);
            } else {
                throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    /**
     * Returns the next command in the sequence and advances the index.
     *
     * @return the next command character.
     * @throws IndexOutOfBoundsException if there are no more commands left.
     */
    public Character nextCommand() {
        if (!hasNextCommand()) {
            throw new IndexOutOfBoundsException("No more commands available.");
        }
        Character currentCommand = commandList.get(currentCommandIndex);
        currentCommandIndex += 1;
        return currentCommand;
    }

    /**
     * Checks if there are more commands left in the sequence.
     *
     * @return true if there are more commands; false otherwise.
     */
    public boolean hasNextCommand() {
        return currentCommandIndex < commandList.size();
    }

    /**
     * Returns the list of commands in the sequence.
     *
     * @return an unmodifiable list of commands.
     */
    public List<Character> getCommands() {
        return new ArrayList<>(commandList);
    }

    /**
     * Validates if a command is one of the allowed commands ('L', 'R', 'F').
     *
     * @param command the command to validate.
     * @return true if the command is valid; false otherwise.
     */
    private boolean isValidCommand(char command) {
        return command == 'L' || command == 'R' || command == 'F';
    }
}
