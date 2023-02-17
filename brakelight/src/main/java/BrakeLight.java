public class BrakeLight implements IBrakeLight{
    private BrakeLightState state;

    public BrakeLight(){
        state = BrakeLightState.OFF;
    }

    public void on(){
        state = BrakeLightState.ON;
    }

    public void off(){
        state = BrakeLightState.OFF;
    }

    //public void visit(IComponentVisitor visitor){}
}
