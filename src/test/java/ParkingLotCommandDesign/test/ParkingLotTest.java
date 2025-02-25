package ParkingLotCommandDesign.test;


import ParkingLotCommandDesign.ParkingLotMain;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ParkingLotTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testInput;
    private ByteArrayOutputStream testOutput;

    @BeforeEach
    void setUp() {
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    private void provideInput(String input) {
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }

    @Test
    @DisplayName("Test valid command: create_parking_lot 5")
    void testCreateParkingLot() {
        provideInput("create_parking_lot 5\nexit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Created a parking lot with 5 slots."));
    }

    @Test
    @DisplayName("Test valid park command")
    void testParkCommand() {
        provideInput("create_parking_lot 2\npark KA-01-HH-1234 Red\nexit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Allocated slot number: 1"));
    }

    @Test
    @DisplayName("Test invalid command")
    void testInvalidCommand() {
        provideInput("invalid_command\nexit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Error: Invalid command"));
    }

    @Test
    @DisplayName("Test leave command")
    void testLeaveCommand() {
        provideInput("create_parking_lot 2\npark KA-01-HH-1234 Red\nleave 1\nexit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Slot number 1 is free."));
    }

    @Test
    @DisplayName("Test empty input")
    void testEmptyInput() {
        provideInput("\nexit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Error: Command cannot be empty"));
    }

    @Test
    @DisplayName("Test exit command")
    void testExitCommand() {
        provideInput("exit\n");

        ParkingLotMain.main(new String[]{});

        String output = testOutput.toString();
        Assertions.assertTrue(output.contains("Exiting the Parking Lot System."));
    }
}
