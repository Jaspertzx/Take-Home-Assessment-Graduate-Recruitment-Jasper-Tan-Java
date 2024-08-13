package org.example.model;

/**
 * Represents a pairing of a car with its corresponding set of instructions.
 * This class is used to manage and execute instructions for a specific car.
 */
public class CarInstructionPair {

    private final Car car;
    private final Instruction instruction;

    /**
     * Constructs a CarInstructionPair with the specified car and its associated instructions.
     *
     * @param car         the car associated with the instructions.
     * @param instruction the set of instructions to be executed by the car.
     */
    public CarInstructionPair(Car car, Instruction instruction) {
        this.car = car;
        this.instruction = instruction;
    }

    /**
     * Gets the car associated with this pair.
     *
     * @return the car associated with the instructions.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Gets the instructions associated with this pair.
     *
     * @return the set of instructions for the car.
     */
    public Instruction getInstruction() {
        return instruction;
    }
}
