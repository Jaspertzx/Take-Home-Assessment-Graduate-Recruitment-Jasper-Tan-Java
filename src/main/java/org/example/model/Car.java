package org.example.model;

/**
 * Represents a car with a name, position, and direction on a board.
 */
public class Car {

    private final String name;
    private Position position;
    private Direction direction;

    /**
     * Constructs a car with a specified initial position and direction.
     *
     * @param x         the x-coordinate of the initial position.
     * @param y         the y-coordinate of the initial position.
     * @param direction the initial direction the car is facing.
     */
    public Car(int x, int y, Direction direction) {
        this(null, x, y, direction);
    }

    /**
     * Constructs a car with a specified name, initial position, and direction.
     *
     * @param name      the name of the car.
     * @param x         the x-coordinate of the initial position.
     * @param y         the y-coordinate of the initial position.
     * @param direction the initial direction the car is facing.
     */
    public Car(String name, int x, int y, Direction direction) {
        this.name = name;
        this.position = new Position(x, y);
        this.direction = direction;
    }

    /**
     * Executes a command to turn the car left, right, or move it forward.
     *
     * @param command the command to execute ('L' for left, 'R' for right, 'F' for forward).
     */
    public void executeCommand(char command) {
        switch (command) {
        case 'L':
            direction = direction.turnLeft();
            break;
        case 'R':
            direction = direction.turnRight();
            break;
        case 'F':
            position = position.move(direction);
            break;
        default:
            throw new IllegalArgumentException("Invalid command: " + command);
        }
    }

    /**
     * Gets the direction the car is currently facing.
     *
     * @return the current direction of the car.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Gets the name of the car.
     *
     * @return the name of the car, or null if no name was provided.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current position of the car.
     *
     * @return the current position of the car.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns a string representation of the car, including its position and direction.
     *
     * @return a string representation of the car.
     */
    @Override
    public String toString() {
        return position.toString() + " " + direction.toString();
    }
}
