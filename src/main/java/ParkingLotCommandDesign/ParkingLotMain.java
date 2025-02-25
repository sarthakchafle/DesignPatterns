package ParkingLotCommandDesign;

import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Parking Lot System. Enter commands:");

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the Parking Lot System.");
                    break;
                }

                String[] inputArgs = input.split("\\s+");
                String commandName = inputArgs[0];
                //returns command from command factory
                Command command = CommandFactory.getCommand(commandName);

                if (command != null) {
                    command.execute(inputArgs);
                } else {
                    System.out.println("Invalid command: " + commandName);
                }
            }
            catch(IllegalStateException illegalStateException){
                System.out.println(illegalStateException.getMessage());
            }
            catch (Exception e){
                System.out.println("Exception occurred please try again");
            }
        }

        scanner.close();
    }
}
