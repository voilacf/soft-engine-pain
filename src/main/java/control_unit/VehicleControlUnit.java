package control_unit;

import command.ICommand;
import events.EventBus;

public class VehicleControlUnit {
    private EventBus eventBus;

    public VehicleControlUnit(){
        eventBus = new EventBus();
    }

    //TODO: add logic
    public void addSubscriber(Subscriber subscriber){

    }

    public void startup(){

    }

    public void move(int deltaRPM, int seconds){

    }

    public void leftTrun(int deltaRPM, int seconds){

    }

    public void rightTurn(int deltaRPM, int seconds){

    }

    public void stop(){

    }

    public void emergencyStop(){

    }

    public void shutdown(){

    }

    void executeCommand(ICommand cmd) {
        cmd.execute();
    }

    /*public void batteryTemperatureChanged(BatteryCell battery, double temperature){

    }

    public void ultraSonicMeasurement(UltraSonicSensor sensor, double distance){

    }*/
}
