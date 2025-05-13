package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private static ElevatorManager instance;
    private final List<Elevator> elevators;
    private final ElevatorSelectionStrategy selectionStrategy;

    private ElevatorManager(int numElevators, ElevatorSelectionStrategy strategy) {
        this.elevators = new ArrayList<>();
        this.selectionStrategy = strategy;
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = ElevatorFactory.createElevator();
            elevator.runElevator();
            elevators.add(elevator);
        }
    }
    public static synchronized ElevatorManager getInstance(int numElevators, ElevatorSelectionStrategy strategy) {
        if (instance == null) {
            instance = new ElevatorManager(numElevators, strategy);
        }
        return instance;
    }

    public synchronized void requestElevator(int floor) {
        Elevator bestElevator = selectionStrategy.selectElevator(elevators, floor);
        bestElevator.addRequest(new Request(floor));
    }
}
