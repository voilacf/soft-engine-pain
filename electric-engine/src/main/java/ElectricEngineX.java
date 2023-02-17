public class ElectricEngineX implements IElectricEngine{
    private ElectricEngineState state;
    private int rpm;

    public ElectricEngineX(){
        state = ElectricEngineState.OFF;
    }

    public void on(){
        state = ElectricEngineState.ON;
    }

    public void off(){
        state = ElectricEngineState.OFF;
    }

    public void increaseRPM(int deltaRPM, int seconds){

    }

    public void decreaseRPM(int deltaRPM, int seconds){

    }
}
