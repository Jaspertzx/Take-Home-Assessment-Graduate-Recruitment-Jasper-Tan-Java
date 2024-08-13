package org.example.service;

import org.example.model.Board;
import org.example.model.Car;
import org.example.model.CarInstructionPair;
import org.example.model.Instruction;
import org.example.model.Position;

/**
 * Services class that handles the simulation of a car moving on a board according to a set of instructions.
 */
public class Simulation {

    private final Board board;
    private final CarInstructionPair carInstructionPair;

    /**
     * Constructs a Simulation with the specified board, car, and instruction set.
     *
     * @param board       the board on which the simulation is run.
     * @param car         the car to be simulated.
     * @param instruction the set of instructions to be executed by the car.
     */
    public Simulation(Board board, Car car, Instruction instruction) {
        this.board = board;
        this.carInstructionPair = new CarInstructionPair(car, instruction);
    }

    /**
     * Runs the simulation by executing all commands in the instruction set.
     *
     * @return a string representing the final position and direction of the car.
     */
    public String runCommands() {
        Car car = carInstructionPair.getCar();
        Instruction instruction = carInstructionPair.getInstruction();

        while (instruction.hasNextCommand()) {
            checkAndExecute(instruction.nextCommand(), car);
        }

        return car.toString() + "\n";
    }

    /**
     * Checks if a command can be executed and then executes it if valid.
     * For a 'F' (move forward) command, it checks if the next position is within bounds.
     *
     * @param command the command to execute.
     * @param car     the car on which the command is executed.
     */
    private void checkAndExecute(char command, Car car) {
        if (command != 'F' || checkValidPosition(car)) {
            car.executeCommand(command);
        }
    }

    /**
     * Validates whether the car's next position is within the board's boundaries.
     *
     * @param car the car whose position is to be validated.
     * @return true if the next position is within bounds; false otherwise.
     */
    private boolean checkValidPosition(Car car) {
        Position nextPosition = car.getPosition().move(car.getDirection());
        return board.isWithinBounds(nextPosition.getX(), nextPosition.getY());
    }
}
