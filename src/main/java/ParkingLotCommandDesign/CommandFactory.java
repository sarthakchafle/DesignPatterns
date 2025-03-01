package ParkingLotCommandDesign;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        //craete parking lot with capacity
        commands.put("create_parking_lot", new CreateParkingLotCommand());
        //leave command
        commands.put("park", new ParkCommand());
        //leave command
        commands.put("leave", new LeaveCommand());
        //allotment status
        commands.put("status", new StatusCommand());
       // find cars by color command commands.put("find_cars_by_color", new FindCarsByColorCommand());
       // find slots by color commands.put("find_slots_by_color", new FindSlotsByColorCommand());
       //find slot by reg number commands.put("find_slot_by_reg_number", new FindSlotByRegNumberCommand());
    }
    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
