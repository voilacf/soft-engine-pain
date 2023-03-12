package s04observer;

public interface IUltraSonicSensorListener {
    void ultraSonicMeasurement(UltraSonicSensor sensor, double distance);
}
