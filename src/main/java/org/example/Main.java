package org.example;

import org.example.model.Board;
import org.example.model.Car;
import org.example.model.Instruction;
import org.example.model.PartSelection;
import org.example.service.SimulateMultipleCars;
import org.example.service.Simulation;
import org.example.util.InputUtil;
import org.example.util.OutputUtil;

/**
 * Serves as the entry point for the car simulation application.
 * Part 1 handles a single car's movement on a grid, while Part 2 simulates the movement of multiple cars and
 * detects collisions.
 */
public class Main {

    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            PartSelection partSelection = InputUtil.readPartSelection();
            String result = "";
            switch (partSelection) {
            case ONE:
                result = handlePartOne();
                OutputUtil.resultPrint(result);
                break;
            case TWO:
                result = handlePartTwo();
                OutputUtil.resultPrint(result);
                break;
            case EXIT:
                isExit = true;
                break;
            default:
                isExit = true;
                break;
            }
        }
    }

    private static String handlePartOne() {
        Board board = InputUtil.readBoardDimensions();
        Car car = InputUtil.readCarDetails(board, "");
        Instruction instruction = InputUtil.readCarInstructions();

        Simulation simulation = new Simulation(board, car, instruction);
        return simulation.runCommands();
    }

    private static String handlePartTwo() {
        Board board = InputUtil.readBoardDimensions();
        SimulateMultipleCars simulateMultipleCars = new SimulateMultipleCars(board);
        while (true) {
            String carName = InputUtil.skipOneLineAndReadCarName();
            if (carName == null) {
                break;
            }
            Car car = InputUtil.readCarDetails(board, carName);
            Instruction instruction = InputUtil.readCarInstructions();
            boolean isSuccessful = simulateMultipleCars.addCarInstructionPair(car, instruction);
            if (!isSuccessful) {
                OutputUtil.systemPrint("Error, car there already");
            }
        }
        return simulateMultipleCars.runCommands();
    }
}
