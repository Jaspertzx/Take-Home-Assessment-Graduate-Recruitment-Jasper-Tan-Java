package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.example.exception.CollisionException;
import org.example.model.Car;
import org.example.model.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Is a unit test for the CollisionException class.
 */
public class CollisionExceptionTest {

    private Car firstCar;
    private Car secondCar;

    @BeforeEach
    public void setUp() {
        firstCar = new Car("Car1", 1, 1, Direction.NORTH);
        secondCar = new Car("Car2", 2, 2, Direction.EAST);
    }

    @Test
    public void testCollisionExceptionMessage() {
        CollisionException exception = new CollisionException("Collision occurred", firstCar, secondCar);

        // Test if the message is correctly set
        assertEquals("Collision occurred", exception.getMessage());
    }

    @Test
    public void testGetFirstCar() {
        CollisionException exception = new CollisionException("Collision occurred", firstCar, secondCar);

        // Test if the first car is correctly set and retrieved
        assertSame(firstCar, exception.getFirstCar());
    }

    @Test
    public void testGetSecondCar() {
        CollisionException exception = new CollisionException("Collision occurred", firstCar, secondCar);

        // Test if the second car is correctly set and retrieved
        assertSame(secondCar, exception.getSecondCar());
    }

    @Test
    public void testGetCollisionReport() {
        CollisionException exception = new CollisionException("Collision occurred", firstCar, secondCar);

        String expectedReport = "Car1 Car2\n" + secondCar.getPosition();

        // Test if the collision report is correctly generated
        assertEquals(expectedReport, exception.getCollisionReport());
    }
}
