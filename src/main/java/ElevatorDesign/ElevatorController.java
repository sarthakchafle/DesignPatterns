package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElevatorController {
    private final List<Elevator> elevators;
    public ElevatorController(int numberOfElevators,int capacity){
        elevators = new ArrayList<>();
        for (int i=0;i<numberOfElevators;i++){
            Elevator elevator = new Elevator(i+1,capacity);
            elevators.add(elevator);
            Thread t = new Thread(elevator);
            t.start();
        }
    }
    void requestElevator(int sourceFloor, int destinationFloor){
        Elevator optimalElevator = findOptimalElevator(sourceFloor,destinationFloor);
        optimalElevator.addRequests(new Request(sourceFloor,destinationFloor));
    }
    Elevator findOptimalElevator(int sourceFloor,int destinationFloor){
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator e: elevators){
            int dist = Math.abs(sourceFloor-e.getCurrentFloor());
            if(dist<minDistance){
                minDistance  =dist;
                optimalElevator =e;
            }
        }
        return  optimalElevator;
    }
}
