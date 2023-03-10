package s07autonomousworkshop;

import s02builder.AutonomousVehicle;

import java.util.ArrayList;

public class LiftingPlatformSensor {
    private final ArrayList<ILiftingPlatformSensorListener> listeners = new ArrayList<>();

    public void addListener(ILiftingPlatformSensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ILiftingPlatformSensorListener listener) {
        listeners.remove(listener);
    }

    public void vehicleRegistered(AutonomousVehicle vehicle) {
        for (ILiftingPlatformSensorListener listener : listeners) {
            listener.vehicleRegistered(vehicle);
        }
    }
}
