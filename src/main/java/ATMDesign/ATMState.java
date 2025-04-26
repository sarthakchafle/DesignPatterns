package ATMDesign;

public interface ATMState {
    //get the name of the current state
    String getStateName();
    //handle state transitions
    ATMState next(ATMMachineContext context);
}
