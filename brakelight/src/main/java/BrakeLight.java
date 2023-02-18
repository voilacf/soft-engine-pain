public class BrakeLight{
    private static final BrakeLight instance = new BrakeLight();
    public Port port;
    private BrakeLightState state;

    public BrakeLight(){
        port = new Port();
    }

    public void innerOn(){
        state = BrakeLightState.ON;
    }

    public void innerOff(){
        state = BrakeLightState.OFF;
    }

    //public void visit(IComponentVisitor visitor){}

    public class Port implements IBrakeLight{

        public void on(){
            innerOn();
        }

        public void off(){
            innerOff();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
