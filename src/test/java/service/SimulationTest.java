package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.model.Board;
import org.example.model.Car;
import org.example.model.Direction;
import org.example.model.Instruction;
import org.example.service.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Is a unit test for the Simulation class.
 */
public class SimulationTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(5, 5); // Create a 5x5 board for testing
    }

    @Test
    public void whenRunCommandsOnValidPath_thenCarEndsInExpectedPosition() {
        Car car = new Car("TestCar", 0, 0, Direction.NORTH);
        Instruction instruction = new Instruction("FFRFF");

        Simulation simulation = new Simulation(board, car, instruction);
        String result = simulation.runCommands();

        assertEquals("2 2 E\n", result);
    }

    @Test
    public void whenRunCommandsWithInvalidMove_thenCarRemainsWithinBounds() {
        Car car = new Car("TestCar", 0, 0, Direction.NORTH);
        Instruction instruction = new Instruction("FFFFFFFF"); // Should try to move out of bounds

        Simulation simulation = new Simulation(board, car, instruction);
        String result = simulation.runCommands();

        assertEquals("0 4 N\n", result); // Car should stop at the top boundary
    }

    @Test
    public void whenRunCommandsWithMultipleTurns_thenCarEndsInCorrectOrientation() {
        Car car = new Car("TestCar", 1, 1, Direction.NORTH);
        Instruction instruction = new Instruction("RFFLFF");

        Simulation simulation = new Simulation(board, car, instruction);
        String result = simulation.runCommands();

        assertEquals("3 3 N\n", result);
    }

    @Test
    public void whenRunCommandsWithEmptyInstruction_thenCarDoesNotMove() {
        Car car = new Car("TestCar", 2, 2, Direction.EAST);
        Instruction instruction = new Instruction(""); // No commands

        Simulation simulation = new Simulation(board, car, instruction);
        String result = simulation.runCommands();

        assertEquals("2 2 E\n", result); // Car should remain in the same position
    }

    @Test
    public void whenRunCommandsOnEdge_thenCarDoesNotMoveOutOfBounds() {
        Car car = new Car("TestCar", 0, 0, Direction.SOUTH);
        Instruction instruction = new Instruction("F");

        Simulation simulation = new Simulation(board, car, instruction);
        String result = simulation.runCommands();

        assertEquals("0 0 S\n", result); // Car should not move since it's already at the edge
    }
}
