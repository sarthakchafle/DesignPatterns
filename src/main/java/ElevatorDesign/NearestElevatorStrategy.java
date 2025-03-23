package ElevatorDesign;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{
    @Override
    public Elevator selectElevator(List<Elevator> elevators, int requestedFloor) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - requestedFloor);
            if (e.getState() == ElevatorState.IDLE && distance < minDistance) {
                best = e;
                minDistance = distance;
            }
        }
        return (best != null) ? best : elevators.get(0);
    }
}
