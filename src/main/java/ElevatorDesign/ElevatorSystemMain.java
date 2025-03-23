package ElevatorDesign;

public class ElevatorSystemMain {
    public static void main(String[] args) {
        ElevatorManager manager = ElevatorManager.getInstance(3, new RoundRobinElevatorStrategy());

        new Thread(() -> manager.requestElevator(9)).start();
        new Thread(() -> manager.requestElevator(1)).start();
        new Thread(() -> manager.requestElevator(9)).start();
        new Thread(() -> manager.requestElevator(1)).start();
        new Thread(() -> manager.requestElevator(7)).start();
//        System.exit(0);
    }
}
