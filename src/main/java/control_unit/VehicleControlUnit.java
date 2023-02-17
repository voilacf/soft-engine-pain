package control_unit;

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

    /*public void batteryTemperatureChanged(BatteryCell battery, double temperature){

    }

    public void ultraSonicMeasurement(UltraSonicSensor sensor, double distance){

    }*/
}
