package ElevatorDesign;

import java.util.LinkedList;
import java.util.Queue;

public class BasicElevator implements Elevator, Runnable {
    private int currentFloor = 1;  // ✅ Start all elevators at Floor 1
    private ElevatorState state = ElevatorState.IDLE;
    private final Queue<Request> requests = new LinkedList<>();

    @Override
    public synchronized void addRequest(Request request) {
        requests.offer(request);
        notifyAll();
    }

    @Override
    public void runElevator() {
        new Thread(this).start();
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public ElevatorState getState() {
        return state;
    }

    @Override
    public void run() {
        while (true) {
            Request request;
            synchronized (this) {  // ✅ Ensures only one thread modifies the request queue at a time
                while (requests.isEmpty()) {
                    try {
                        wait();  // ✅ Elevator thread waits if there are no requests
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                request = requests.poll(); // ✅ Safely retrieves the next request
            }
            processRequest(request);
        }
    }

    private void processRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " moving to floor: " + request.getFloor());
        state = ElevatorState.MOVING;
        try {
            Thread.sleep(Math.abs(request.getFloor() - currentFloor) * 1000L); // Simulating movement
            currentFloor = request.getFloor();
            System.out.println(Thread.currentThread().getName() + " reached floor: " + currentFloor);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        state = ElevatorState.IDLE;
    }
}
