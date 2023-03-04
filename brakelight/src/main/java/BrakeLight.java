public class BrakeLight {
    private static final BrakeLight instance = new BrakeLight();
    public Port port;
    private BrakeLightState state;

    public BrakeLight() {
        port = new Port();
    }

    public static BrakeLight getInstance() {
        return instance;
    }

    private void innerOn() {
        state = BrakeLightState.ON;
    }

    private void innerOff() {
        state = BrakeLightState.OFF;
    }

    private BrakeLightState innerGetState(){
        return state;
    }

    //public void visit(IComponentVisitor visitor){}

    public class Port implements IBrakeLight {

        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        public String getState(){
            return innerGetState().toString().toLowerCase();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
