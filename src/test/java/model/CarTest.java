package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.Car;
import org.example.model.Direction;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Is a unit tests for the Car class.
 */
public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar", 0, 0, Direction.NORTH);
    }

    @Test
    public void whenConstructedWithName_thenCarHasCorrectName() {
        Car namedCar = new Car("TestCar", 1, 2, Direction.EAST);
        assertEquals("TestCar", namedCar.getName());
    }

    @Test
    public void whenConstructedWithoutName_thenCarNameIsNull() {
        Car unnamedCar = new Car(1, 2, Direction.EAST);
        assertEquals(null, unnamedCar.getName());
    }

    @Test
    public void whenTurnLeftFromNorth_thenDirectionIsWest() {
        car.executeCommand('L');
        assertEquals(Direction.WEST, car.getDirection());
    }

    @Test
    public void whenTurnRightFromNorth_thenDirectionIsEast() {
        car.executeCommand('R');
        assertEquals(Direction.EAST, car.getDirection());
    }

    @Test
    public void whenMoveForwardFromNorthAtOrigin_thenPositionIsUpdated() {
        car.executeCommand('F');
        assertEquals(new Position(0, 1), car.getPosition());
    }

    @Test
    public void whenMoveForwardFromEast_thenPositionIsUpdated() {
        car = new Car("TestCar", 1, 1, Direction.EAST);
        car.executeCommand('F');
        assertEquals(new Position(2, 1), car.getPosition());
    }

    @Test
    public void whenMoveForwardFromSouth_thenPositionIsUpdated() {
        car = new Car("TestCar", 1, 1, Direction.SOUTH);
        car.executeCommand('F');
        assertEquals(new Position(1, 0), car.getPosition());
    }

    @Test
    public void whenMoveForwardFromWest_thenPositionIsUpdated() {
        car = new Car("TestCar", 1, 1, Direction.WEST);
        car.executeCommand('F');
        assertEquals(new Position(0, 1), car.getPosition());
    }

    @Test
    public void whenExecuteInvalidCommand_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> car.executeCommand('X'));
    }

    @Test
    public void whenCarToStringCalled_thenCorrectStringRepresentation() {
        assertEquals("0 0 N", car.toString());
    }
}
