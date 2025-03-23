package ElevatorDesign;

public class ElevatorFactory {
    public static Elevator createElevator(){
        return new BasicElevator();
    }
}
