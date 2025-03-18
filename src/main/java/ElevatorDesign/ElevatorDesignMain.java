package ElevatorDesign;

public class ElevatorDesignMain {
    public static void main(String[] args) {
        ElevatorController elevatorController = new ElevatorController(3,5);
        elevatorController.requestElevator(10,2);
        elevatorController.requestElevator(3,7);
        elevatorController.requestElevator(8,2);
        elevatorController.requestElevator(1,9);
    }
}
