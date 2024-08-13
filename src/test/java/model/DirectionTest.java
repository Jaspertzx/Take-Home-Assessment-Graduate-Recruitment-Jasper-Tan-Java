package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.Direction;
import org.junit.jupiter.api.Test;

/**
 * Is a unit test for the Direction enum.
 */
public class DirectionTest {

    @Test
    public void whenTurnLeftFromNorth_thenDirectionIsWest() {
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
    }

    @Test
    public void whenTurnLeftFromWest_thenDirectionIsSouth() {
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
    }

    @Test
    public void whenTurnLeftFromSouth_thenDirectionIsEast() {
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
    }

    @Test
    public void whenTurnLeftFromEast_thenDirectionIsNorth() {
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
    }

    @Test
    public void whenTurnRightFromNorth_thenDirectionIsEast() {
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
    }

    @Test
    public void whenTurnRightFromEast_thenDirectionIsSouth() {
        assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
    }

    @Test
    public void whenTurnRightFromSouth_thenDirectionIsWest() {
        assertEquals(Direction.WEST, Direction.SOUTH.turnRight());
    }

    @Test
    public void whenTurnRightFromWest_thenDirectionIsNorth() {
        assertEquals(Direction.NORTH, Direction.WEST.turnRight());
    }

    @Test
    public void whenFromStringWithValidInput_thenReturnsCorrectDirection() {
        assertEquals(Direction.NORTH, Direction.fromString("N"));
        assertEquals(Direction.EAST, Direction.fromString("E"));
        assertEquals(Direction.SOUTH, Direction.fromString("S"));
        assertEquals(Direction.WEST, Direction.fromString("W"));
    }

    @Test
    public void whenFromStringWithLowerCaseInput_thenReturnsCorrectDirection() {
        assertEquals(Direction.NORTH, Direction.fromString("n"));
        assertEquals(Direction.EAST, Direction.fromString("e"));
        assertEquals(Direction.SOUTH, Direction.fromString("s"));
        assertEquals(Direction.WEST, Direction.fromString("w"));
    }

    @Test
    public void whenFromStringWithInvalidInput_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Direction.fromString("X"));
    }

    @Test
    public void whenToStringCalled_thenReturnsCorrectStringRepresentation() {
        assertEquals("N", Direction.NORTH.toString());
        assertEquals("E", Direction.EAST.toString());
        assertEquals("S", Direction.SOUTH.toString());
        assertEquals("W", Direction.WEST.toString());
    }
}
