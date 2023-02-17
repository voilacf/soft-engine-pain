package bridge;

public class ElectricEngineNG implements IElectricEngine {
    // new ElectricEngineState state;
    int rpm;

    @Override
    public void on(){

    }

    @Override
    public void off(){

    }

    @Override
    public void increaseRPM(int deltaRPM, int seconds){

    }

    @Override
    public void decreaseRPM(int deltaRPM, int seconds){

    }

    @Override
    public int computePowerDrawPerSecond(){
        return 4; //TODO implement right
    }

}
