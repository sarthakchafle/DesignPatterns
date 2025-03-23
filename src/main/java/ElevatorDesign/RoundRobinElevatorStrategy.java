package ElevatorDesign;

import java.util.List;

public class RoundRobinElevatorStrategy implements ElevatorSelectionStrategy {
    private int lastAssigned = 0; // Keeps track of last assigned elevator

    @Override
    public synchronized Elevator selectElevator(List<Elevator> elevators, int requestedFloor) {
        Elevator selectedElevator = elevators.get(lastAssigned % elevators.size());
        lastAssigned++; // Move to the next elevator in a round-robin manner
        return selectedElevator;
    }
}
