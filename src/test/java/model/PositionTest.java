package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.example.model.Direction;
import org.example.model.Position;
import org.junit.jupiter.api.Test;

/**
 * Is a unit test for the Position class.
 */
public class PositionTest {

    @Test
    public void whenConstructedWithCoordinates_thenCoordinatesAreStoredCorrectly() {
        Position position = new Position(3, 5);
        assertEquals(3, position.getX());
        assertEquals(5, position.getY());
    }

    @Test
    public void whenMoveNorth_thenYCoordinateIncreases() {
        Position position = new Position(2, 2);
        Position newPosition = position.move(Direction.NORTH);
        assertEquals(2, newPosition.getX());
        assertEquals(3, newPosition.getY());
    }

    @Test
    public void whenMoveEast_thenXCoordinateIncreases() {
        Position position = new Position(2, 2);
        Position newPosition = position.move(Direction.EAST);
        assertEquals(3, newPosition.getX());
        assertEquals(2, newPosition.getY());
    }

    @Test
    public void whenMoveSouth_thenYCoordinateDecreases() {
        Position position = new Position(2, 2);
        Position newPosition = position.move(Direction.SOUTH);
        assertEquals(2, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    public void whenMoveWest_thenXCoordinateDecreases() {
        Position position = new Position(2, 2);
        Position newPosition = position.move(Direction.WEST);
        assertEquals(1, newPosition.getX());
        assertEquals(2, newPosition.getY());
    }

    @Test
    public void whenEqualsCalledWithSameCoordinates_thenReturnsTrue() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        assertEquals(position1, position2);
    }

    @Test
    public void whenEqualsCalledWithDifferentCoordinates_thenReturnsFalse() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(4, 5);
        assertNotEquals(position1, position2);
    }

    @Test
    public void whenHashCodeCalledWithSameCoordinates_thenReturnsSameHashCode() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void whenHashCodeCalledWithDifferentCoordinates_thenReturnsDifferentHashCode() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(4, 5);
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void whenToStringCalled_thenReturnsCorrectStringRepresentation() {
        Position position = new Position(3, 5);
        assertEquals("3 5", position.toString());
    }
}
