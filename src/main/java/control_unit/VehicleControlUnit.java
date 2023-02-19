package control_unit;

import builder.AutonomousVehicle;
import com.google.common.eventbus.EventBus;
import door_button.ICommand;
import events.*;
import observer.IBatteryCellTemperatureListener;
import observer.IUltraSonicSensorListener;
import observer.UltraSonicSensor;

public class VehicleControlUnit implements IBatteryCellTemperatureListener, IUltraSonicSensorListener {
    private final EventBus eventBus;
    private final AutonomousVehicle vehicle;

    public VehicleControlUnit(AutonomousVehicle vehicle) {
        eventBus = new EventBus();
        this.vehicle = vehicle;
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void startup() {
        eventBus.post(new EventEngineOn());
        eventBus.post(new EventLEDOn());
        eventBus.post(new EventGPSOn());
        eventBus.post(new EventGPSConnectSatellite("118.75"));
        eventBus.post(new EventCameraOn());
        eventBus.post(new EventLidarOn());
        eventBus.post(new EventLeftIndicatorOff());
        eventBus.post(new EventRightIndicatorOff());
    }

    public void move(int deltaRPM, int seconds) {
        eventBus.post(new EventLeftIndicatorOff());
        eventBus.post(new EventRightIndicatorOff());
        eventBus.post(new EventLEDDimmed());
        eventBus.post(new EventEngineIncreaseRPM(deltaRPM, seconds));
        eventBus.post(new EventBrakeSet(0));
        eventBus.post(new EventBrakeLightOff());
    }

    public void leftTurn(int deltaRPM, int seconds) {
        eventBus.post(new EventLeftIndicatorOn());
        eventBus.post(new EventEngineDecreaseRPM(deltaRPM, seconds));
        eventBus.post(new EventBrakeSet(70));
        eventBus.post(new EventBrakeLightOn());
    }

    public void rightTurn(int deltaRPM, int seconds) {
        eventBus.post(new EventRightIndicatorOn());
        eventBus.post(new EventEngineDecreaseRPM(deltaRPM, seconds));
        eventBus.post(new EventBrakeSet(70));
        eventBus.post(new EventBrakeLightOn());
    }

    public void stop() {
        eventBus.post(new EventBrakeSet(100));
        eventBus.post(new EventBrakeLightOn());
    }

    public void emergencyStop() {
        eventBus.post(new EventBrakeSet(100));
        eventBus.post(new EventBrakeLightOn());
        eventBus.post(new EventHazardWarningOn());
        eventBus.post(new EventEngineOff());
        eventBus.post(new EventLedHighBeam());
        eventBus.post(new EventCameraOff());
        eventBus.post(new EventLidarOff());
    }

    public void shutdown() {
        eventBus.post(new EventBrakeSet(100));
        eventBus.post(new EventEngineOff());
        eventBus.post(new EventBrakeLightOff());
        eventBus.post(new EventLEDOff());
        eventBus.post(new EventHazardWarningOff());
        eventBus.post(new EventGPSOff());
        eventBus.post(new EventCameraOff());
        eventBus.post(new EventLidarOff());
    }

    void executeCommand(ICommand cmd) {
        cmd.execute();
    }


    @Override
    public void batterytemperatureChanged(double temperature, Object battery) {
        System.out.println("Battery temperature changed to " + temperature + "°C");
    }

    @Override
    public void ultraSonicMeasurement(UltraSonicSensor sensor, double distance) {
        System.out.println("UltraSonicSensor " + sensor.getId() + " distance changed to " + distance + "m");
    }

    public AutonomousVehicle getVehicle() {
        return vehicle;
    }
}
