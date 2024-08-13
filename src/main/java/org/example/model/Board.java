package org.example.model;

/**
 * Represents a rectangular board with a specified width and height.
 * The board is used to determine whether a given position is within its bounds.
 */
public class Board {

    private final int width;
    private final int height;

    /**
     * Constructs a Board with the specified width and height.
     *
     * @param width  the width of the board.
     * @param height the height of the board.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if the specified (x, y) position is within the bounds of the board.
     *
     * @param x the x-coordinate of the position.
     * @param y the y-coordinate of the position.
     * @return true if the position is within bounds; false otherwise.
     */
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
