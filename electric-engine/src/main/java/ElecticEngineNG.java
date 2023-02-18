public class ElecticEngineNG{
    private static final ElecticEngineNG instance = new ElecticEngineNG();
    public Port port;
    private ElectricEngineState state;
    private int rpm;

    public ElecticEngineNG(){
        port = new Port();
    }

    public void innerOn(){
        state = ElectricEngineState.ON;
    }

    public void innerOff(){
        state = ElectricEngineState.OFF;
    }

    public void innerIncreaseRPM(int deltaRPM, int seconds){

    }

    public void innerDecreaseRPM(int deltaRPM, int seconds){

    }

    public class Port implements IElectricEngine{

        public void on(){
            innerOn();
        }

        public void off(){
            innerOff();
        }

        public void increaseRPM(int deltaRPM, int seconds){
            innerIncreaseRPM(deltaRPM,seconds);
        }

        public void decreaseRPM(int deltaRPM, int seconds){
            innerDecreaseRPM(deltaRPM,seconds);
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
