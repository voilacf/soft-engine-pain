public class ElectricEngineX{
    private static final ElectricEngineX instance = new ElectricEngineX();
    public Port port;
    private ElectricEngineState state;
    private int rpm;

    public ElectricEngineX(){
        port = new Port();
    }

    public void innerOn(){
        state = ElectricEngineState.ON;
    }

    public void innerOff(){
        state = ElectricEngineState.OFF;
    }

    public void innerIncreaseRPM(int deltaRPM, int seconds){
        rpm = (int)(2*Math.PI*deltaRPM)/(seconds/60);
        //TODO: change rpm to double? + check if calculation is correct
    }

    public void innerDecreaseRPM(int deltaRPM, int seconds){
        rpm = (int)(2*Math.PI*deltaRPM)/(seconds/60);
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
    }
}
