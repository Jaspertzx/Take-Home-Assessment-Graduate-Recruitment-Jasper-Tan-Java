package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.example.model.PartSelection;
import org.example.util.InputUtil;
import org.junit.jupiter.api.Test;

/**
 * Is a unit test for the InputUtil class.
 */
public class InputUtilTest {

    @Test
    public void whenInvalidPartSelection_thenReturnsExit() {
        String input = "invalid\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(PartSelection.EXIT, InputUtil.readPartSelection());
    }

    @Test
    public void whenEmptyLineSkipped_thenReadsCarNameCorrectly() {
        String input = "\nCarName\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals("CarName", InputUtil.skipOneLineAndReadCarName());
    }
}
