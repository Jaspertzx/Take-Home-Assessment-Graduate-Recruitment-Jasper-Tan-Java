package org.example.model;

import java.util.Objects;

/**
 * Represents a position on a 2D grid with x and y coordinates.
 * This class provides methods to move the position in a specified direction
 * and to compare positions for equality.
 */
public class Position {

    private final int xCoordinate;
    private final int yCoordinate;

    /**
     * Constructs a Position with the specified x and y coordinates.
     *
     * @param xCoordinate the x-coordinate of the position.
     * @param yCoordinate the y-coordinate of the position.
     */
    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns a new Position object that results from moving this position
     * in the specified direction.
     *
     * @param direction the direction to move (NORTH, EAST, SOUTH, or WEST).
     * @return a new Position object after the move.
     */
    public Position move(Direction direction) {
        int newXCoordinate = this.xCoordinate;
        int newYCoordinate = this.yCoordinate;
        switch (direction) {
        case NORTH:
            newYCoordinate += 1;
            break;
        case EAST:
            newXCoordinate += 1;
            break;
        case SOUTH:
            newYCoordinate -= 1;
            break;
        case WEST:
            newXCoordinate -= 1;
            break;
        default:
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        return new Position(newXCoordinate, newYCoordinate);
    }

    /**
     * Gets the x-coordinate of this position.
     *
     * @return the x-coordinate.
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Gets the y-coordinate of this position.
     *
     * @return the y-coordinate.
     */
    public int getY() {
        return yCoordinate;
    }

    /**
     * Checks if this position is equal to another object.
     * Two positions are considered equal if they have the same x and y coordinates.
     *
     * @param o the object to compare with.
     * @return true if the positions are equal; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return (xCoordinate == position.xCoordinate) && (yCoordinate == position.yCoordinate);
    }

    /**
     * Returns a hash code value for this position based on its coordinates.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    /**
     * Returns a string representation of this position in the format "x y".
     *
     * @return a string representation of this position.
     */
    @Override
    public String toString() {
        return xCoordinate + " " + yCoordinate;
    }
}
