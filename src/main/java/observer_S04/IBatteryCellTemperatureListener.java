package observer_S04;

public interface IBatteryCellTemperatureListener {
    void batteryTemperatureChanged(double temperature, Object battery);
}
