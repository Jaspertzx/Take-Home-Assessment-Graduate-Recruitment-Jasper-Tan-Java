package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.example.model.Instruction;
import org.junit.jupiter.api.Test;

/**
 * Is a unit test for the Instruction class.
 */
public class InstructionTest {

    @Test
    public void whenConstructedWithValidCommands_thenCommandsAreStoredCorrectly() {
        Instruction instruction = new Instruction("FRLFRL");
        List<Character> expectedCommands = List.of('F', 'R', 'L', 'F', 'R', 'L');
        assertEquals(expectedCommands, instruction.getCommands());
    }

    @Test
    public void whenConstructedWithInvalidCommand_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Instruction("FRLX"));
    }

    @Test
    public void whenConstructedWithEmptyString_thenCommandListIsEmpty() {
        Instruction instruction = new Instruction("");
        assertTrue(instruction.getCommands().isEmpty());
    }

    @Test
    public void whenNextCommandCalled_thenReturnsNextCommandAndAdvancesIndex() {
        Instruction instruction = new Instruction("FRL");
        assertEquals('F', instruction.nextCommand());
        assertEquals('R', instruction.nextCommand());
        assertEquals('L', instruction.nextCommand());
    }

    @Test
    public void whenNextCommandCalledWithoutRemainingCommands_thenThrowsIndexOutOfBoundsException() {
        Instruction instruction = new Instruction("F");
        instruction.nextCommand(); // Consume the only command
        assertThrows(IndexOutOfBoundsException.class, instruction::nextCommand);
    }

    @Test
    public void whenHasNextCommandWithRemainingCommands_thenReturnsTrue() {
        Instruction instruction = new Instruction("FRL");
        assertTrue(instruction.hasNextCommand());
    }

    @Test
    public void whenHasNextCommandWithNoRemainingCommands_thenReturnsFalse() {
        Instruction instruction = new Instruction("F");
        instruction.nextCommand(); // Consume the only command
        assertFalse(instruction.hasNextCommand());
    }

    @Test
    public void whenGetCommandsCalled_thenReturnsCopyOfCommandList() {
        Instruction instruction = new Instruction("FRL");
        List<Character> commands = instruction.getCommands();
        assertEquals(List.of('F', 'R', 'L'), commands);

        commands.add('X');
        assertEquals(List.of('F', 'R', 'L'), instruction.getCommands());
    }
}
