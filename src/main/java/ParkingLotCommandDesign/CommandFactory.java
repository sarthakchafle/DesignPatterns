package ParkingLotCommandDesign;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    static {

        commands.put("create_parking_lot", new CreateParkingLotCommand());
        commands.put("park", new ParkCommand());
        commands.put("leave", new LeaveCommand());
        commands.put("status", new StatusCommand());
        commands.put("find_cars_by_color", new FindCarsByColorCommand());
        commands.put("find_slots_by_color", new FindSlotsByColorCommand());
        commands.put("find_slot_by_reg_number", new FindSlotByRegNumberCommand());
    }
    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
