package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Is a unit test for the Board class.
 */
public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(10, 10); // Creating a 10x10 board for testing
    }

    @Test
    public void whenPositionIsWithinBounds_thenReturnsTrue() {
        // Test positions well within bounds
        assertTrue(board.isWithinBounds(0, 0));
        assertTrue(board.isWithinBounds(5, 5));
        assertTrue(board.isWithinBounds(9, 9));
    }

    @Test
    public void whenPositionIsOnEdge_thenReturnsTrue() {
        // Test positions on the edge but still within bounds
        assertTrue(board.isWithinBounds(0, 0)); // Bottom-left corner
        assertTrue(board.isWithinBounds(9, 9)); // Top-right corner
    }

    @Test
    public void whenPositionIsOutOfBounds_thenReturnsFalse() {
        // Test positions outside the board boundaries
        assertFalse(board.isWithinBounds(-1, 0)); // Left of the board
        assertFalse(board.isWithinBounds(0, -1)); // Below the board
        assertFalse(board.isWithinBounds(10, 0)); // Right of the board
        assertFalse(board.isWithinBounds(0, 10)); // Above the board
    }

    @Test
    public void whenPositionIsAtNegativeCoordinates_thenReturnsFalse() {
        // Test negative coordinates, which should be out of bounds
        assertFalse(board.isWithinBounds(-1, -1));
        assertFalse(board.isWithinBounds(-1, 5));
        assertFalse(board.isWithinBounds(5, -1));
    }

    @Test
    public void whenPositionIsBeyondMaximumCoordinates_thenReturnsFalse() {
        // Test positions just beyond the maximum allowed coordinates
        assertFalse(board.isWithinBounds(10, 10));
        assertFalse(board.isWithinBounds(11, 9));
        assertFalse(board.isWithinBounds(9, 11));
    }
}
