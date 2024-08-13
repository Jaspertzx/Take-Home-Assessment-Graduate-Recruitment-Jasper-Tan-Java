package org.example.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.exception.CollisionException;
import org.example.model.Board;
import org.example.model.Car;
import org.example.model.CarInstructionPair;
import org.example.model.Instruction;
import org.example.model.Position;

/**
 * Services class that simulates the movement of multiple cars on a board, handling collisions and commands.
 */
public class SimulateMultipleCars {

    private final Board board;
    private final ArrayList<CarInstructionPair> carInstructionPairs;
    private final HashMap<Position, Car> carPositions;

    /**
     * Constructs a SimulateMultipleCars object with the specified board.
     *
     * @param board the board on which the cars will be simulated.
     */
    public SimulateMultipleCars(Board board) {
        this.board = board;
        this.carPositions = new HashMap<>();
        this.carInstructionPairs = new ArrayList<>();
    }

    /**
     * Adds a car and its associated instructions to the simulation.
     *
     * @param car         the car to be added.
     * @param instruction the instructions to be executed by the car.
     * @return true if the car and instructions were successfully added; false if car's position is already occupied.
     */
    public boolean addCarInstructionPair(Car car, Instruction instruction) {
        if (carPositions.containsKey(car.getPosition())) {
            return false;
        }
        if (checkValidPosition(car)) {
            carInstructionPairs.add(new CarInstructionPair(car, instruction));
            carPositions.put(car.getPosition(), car);
            return true;
        }
        return false;
    }

    /**
     * Runs the simulation by executing all commands for each car until all commands are completed or a collision
     * occurs.
     *
     * @return a string reporting the result of the simulation, including any collision details.
     */
    public String runCommands() {
        int stepCount = 0;
        int completedCarCount = 0;
        while (completedCarCount != carInstructionPairs.size()) {
            stepCount += 1;
            try {
                completedCarCount = simulateStep();
            } catch (CollisionException e) {
                return e.getCollisionReport() + "\n" + stepCount + "\n";
            }
        }
        return "No collisions\n";
    }

    /**
     * Updates the position of a car on the board.
     *
     * @param oldPosition the previous position of the car.
     * @param newPosition the new position of the car.
     * @param car         the car being moved.
     */
    private void updateCarPosition(Position oldPosition, Position newPosition, Car car) {
        carPositions.remove(oldPosition);
        carPositions.put(newPosition, car);
    }

    /**
     * Checks if there is a collision at the given position.
     *
     * @param position the position to check for a collision.
     * @return true if there is a collision; false otherwise.
     */
    private boolean isCollision(Position position) {
        return carPositions.containsKey(position);
    }

    /**
     * Retrieves the car located at the specified position.
     *
     * @param position the position to check.
     * @return the car at the specified position, or null if no car is present.
     */
    private Car getCarAtPosition(Position position) {
        return carPositions.get(position);
    }

    /**
     * Simulates a single step for all cars, executing their next command.
     *
     * @return the number of cars that have completed all of their commands.
     */
    private int simulateStep() {
        int completedPairs = 0;
        for (CarInstructionPair currentPair : carInstructionPairs) {
            boolean isCompleted = simulateCarInstructions(currentPair);
            if (isCompleted) {
                completedPairs += 1;
            }
        }
        return completedPairs;
    }

    /**
     * Simulates the execution of the next command for a specific car.
     *
     * @param carInstructionPair the car and its associated instructions to simulate.
     * @return true if the car has completed all its commands; false otherwise.
     */
    private boolean simulateCarInstructions(CarInstructionPair carInstructionPair) {
        if (!carInstructionPair.getInstruction().hasNextCommand()) {
            return true;
        }

        Car car = carInstructionPair.getCar();
        Position oldPosition = car.getPosition();
        Instruction instruction = carInstructionPair.getInstruction();

        executeCommand(instruction.nextCommand(), car);

        updateCarPosition(oldPosition, car.getPosition(), car);
        return !instruction.hasNextCommand();
    }

    /**
     * Executes a given command for a car, checking for collisions when moving forward.
     *
     * @param command the command to execute.
     * @param car     the car on which the command is executed.
     */
    private void executeCommand(char command, Car car) {
        if (command != 'F') {
            car.executeCommand(command);
            return;
        }
        if (checkValidPosition(car)) {
            car.executeCommand(command);
            if (isCollision(car.getPosition())) {
                throw new CollisionException("Collision Detected", getCarAtPosition(car.getPosition()), car);
            }
        }
    }

    /**
     * Validates whether the car's next position is within the board's boundaries.
     *
     * @param car the car whose next position is to be validated.
     * @return true if the next position is within bounds; false otherwise.
     */
    private boolean checkValidPosition(Car car) {
        Position nextPosition = car.getPosition().move(car.getDirection());
        return board.isWithinBounds(nextPosition.getX(), nextPosition.getY());
    }
}
