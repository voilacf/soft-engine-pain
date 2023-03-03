package observer_S04;

import builder.AutonomousVehicle;
import charging_station.EventCharging;
import com.google.common.eventbus.EventBus;
import control_unit.ComponentUtils;
import control_unit.Subscriber;
import events.*;

import java.util.Arrays;
import java.util.List;

public class VehicleControlUnit implements IBatteryCellTemperatureListener, IUltraSonicSensorListener {
    private final EventBus eventBus;
    private final AutonomousVehicle vehicle;
    private boolean isStarted = false;

    public VehicleControlUnit(AutonomousVehicle vehicle) {
        eventBus = new EventBus();
        this.vehicle = vehicle;

        // Add as listener
        Arrays.stream(vehicle.getUltraSonics()).forEach(ultraSonic -> ultraSonic.addListener(this));
        addBatteryListeners(vehicle.getBattery());
    }

    private void addBatteryListeners(Object batteryUnit) {
        Boolean isComposite = (Boolean) ComponentUtils.invokeMethod(batteryUnit, "isComposite");
        assert isComposite != null;
        if (isComposite) {
            List<Object> subUnits = (List<Object>) ComponentUtils.invokeMethod(batteryUnit, "getSubUnits");
            assert subUnits != null;
            subUnits.forEach(this::addBatteryListeners);
        } else {
            ComponentUtils.invokeMethod(batteryUnit, "addListener", new Class[]{Object.class}, this);
        }
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
        isStarted = true;
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
        isStarted = false;
    }

    public void charging(int amountOfEnergy) {
        eventBus.post(new EventCharging(amountOfEnergy));
    }

    @Override
    public void batteryTemperatureChanged(double temperature, Object battery) {
        // Temperature of battery cell changed
        System.out.println("Battery temperature changed to " + temperature + "°C");
    }

    @Override
    public void ultraSonicMeasurement(UltraSonicSensor sensor, double distance) {
        // Distance of ultrasonic sensor changed
        System.out.println("UltraSonicSensor " + sensor.getId() + " distance changed to " + distance + "m");
    }

    public AutonomousVehicle getVehicle() {
        return vehicle;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
