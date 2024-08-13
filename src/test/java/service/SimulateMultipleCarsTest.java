package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.model.Board;
import org.example.model.Car;
import org.example.model.Direction;
import org.example.model.Instruction;
import org.example.model.Position;
import org.example.service.SimulateMultipleCars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Is a unit test for the SimulateMultipleCars class.
 */
public class SimulateMultipleCarsTest {

    private Board board;
    private SimulateMultipleCars simulateMultipleCars;

    @BeforeEach
    public void setUp() {
        board = new Board(5, 5); // Create a 5x5 board for testing
        simulateMultipleCars = new SimulateMultipleCars(board);
    }

    @Test
    public void whenAddCarWithValidPosition_thenCarIsAdded() {
        Car car = new Car("Car1", 1, 1, Direction.NORTH);
        Instruction instruction = new Instruction("FFRFF");
        assertTrue(simulateMultipleCars.addCarInstructionPair(car, instruction));
    }

    @Test
    public void whenAddCarWithOccupiedPosition_thenCarIsNotAdded() {
        Car car1 = new Car("Car1", 1, 1, Direction.NORTH);
        Car car2 = new Car("Car2", 1, 1, Direction.SOUTH);
        Instruction instruction1 = new Instruction("FFRFF");
        Instruction instruction2 = new Instruction("FFLFF");

        simulateMultipleCars.addCarInstructionPair(car1, instruction1);
        assertFalse(simulateMultipleCars.addCarInstructionPair(car2, instruction2));
    }

    @Test
    public void whenAddCarWithInvalidPosition_thenCarIsNotAdded() {
        Car car = new Car("Car1", 6, 6, Direction.NORTH); // Position out of bounds
        Instruction instruction = new Instruction("FFRFF");
        assertFalse(simulateMultipleCars.addCarInstructionPair(car, instruction));
    }

    @Test
    public void whenRunCommandsWithoutCollisions_thenReturnsNoCollisionsDetected() {
        Car car1 = new Car("Car1", 1, 1, Direction.NORTH);
        Car car2 = new Car("Car2", 2, 2, Direction.EAST);
        Instruction instruction1 = new Instruction("FFRFF");
        Instruction instruction2 = new Instruction("FFLFF");

        simulateMultipleCars.addCarInstructionPair(car1, instruction1);
        simulateMultipleCars.addCarInstructionPair(car2, instruction2);

        assertEquals("No collisions\n", simulateMultipleCars.runCommands());
    }

    @Test
    public void whenRunCommandsWithCollision_thenReturnsCollisionReport() {
        Car car1 = new Car("Car1", 1, 1, Direction.NORTH);
        Car car2 = new Car("Car2", 1, 2, Direction.SOUTH);
        Instruction instruction1 = new Instruction("F"); // Car1 moves from (1, 1) to (1, 2)
        Instruction instruction2 = new Instruction("F"); // Car2 moves from (1, 2) to (1, 1)

        simulateMultipleCars.addCarInstructionPair(car1, instruction1);
        simulateMultipleCars.addCarInstructionPair(car2, instruction2);

        String expectedReport = "Car1 Car2\n1 2\n1\n";
        String result = simulateMultipleCars.runCommands();
        assertTrue(result.contains("Car2"));
    }

    @Test
    public void whenRunCommands_thenCarPositionsUpdatedCorrectly() {
        Car car = new Car("Car1", 0, 0, Direction.NORTH);
        Instruction instruction = new Instruction("FFRFF");

        simulateMultipleCars.addCarInstructionPair(car, instruction);
        simulateMultipleCars.runCommands();

        assertEquals(new Position(2, 2), car.getPosition());
        assertEquals(Direction.EAST, car.getDirection());
    }

    @Test
    public void whenRunCommandsAllCommandsExecuted_thenAllCarsComplete() {
        Car car1 = new Car("Car1", 1, 1, Direction.NORTH);
        Instruction instruction1 = new Instruction("FFRFF");

        simulateMultipleCars.addCarInstructionPair(car1, instruction1);
        simulateMultipleCars.runCommands();

        assertFalse(instruction1.hasNextCommand());
    }
}
