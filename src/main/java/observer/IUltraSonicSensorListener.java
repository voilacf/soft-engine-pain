package observer;

import builder.UltraSonicSensor;

public interface IUltraSonicSensorListener {
    void ultraSonicMeasurement(UltraSonicSensor sensor, double distance);
}
