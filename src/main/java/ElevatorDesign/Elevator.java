package ElevatorDesign;

interface Elevator {
    void addRequest(Request request);
    void runElevator();
    int getCurrentFloor();
    ElevatorState getState();
}
