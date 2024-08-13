package org.example.model;

/**
 * Enums representing the four cardinal directions: North, East, South, and West.
 * This enum provides methods to turn left or right from a given direction,
 * and to convert from and to string representations.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Returns the direction after making a 90-degree left turn.
     *
     * @return the direction after turning left.
     */
    public Direction turnLeft() {
        return values()[(this.ordinal() + 3) % 4];
    }

    /**
     * Returns the direction after making a 90-degree right turn.
     *
     * @return the direction after turning right.
     */
    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % 4];
    }

    /**
     * Converts a string representation of a direction to the corresponding enum value.
     * The input string can be in any case and must be one of "N", "E", "S", or "W".
     *
     * @param direction the string representation of the direction.
     * @return the corresponding Direction enum value.
     * @throws IllegalArgumentException if the input string is not a valid direction.
     */
    public static Direction fromString(String direction) {
        switch (direction.toUpperCase()) {
        case "N":
            return NORTH;
        case "E":
            return EAST;
        case "S":
            return SOUTH;
        case "W":
            return WEST;
        default:
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    /**
     * Returns the string representation of the direction.
     * The representation is a single character: "N", "E", "S", or "W".
     *
     * @return the string representation of the direction.
     */
    @Override
    public String toString() {
        switch (this) {
        case NORTH:
            return "N";
        case EAST:
            return "E";
        case SOUTH:
            return "S";
        case WEST:
            return "W";
        default:
            throw new IllegalArgumentException("Invalid direction");
        }
    }
}
