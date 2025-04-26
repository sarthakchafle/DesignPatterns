package ATMDesign;

public class IdleState implements ATMState{
    @Override
    public String getStateName() {
        return "IDLE STATE";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard()!=null){
            //next state
            return context.getStateFactory().createHasCardState();
        }
        //return to same state
        return this;
    }
}
