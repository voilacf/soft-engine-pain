package observer;

public interface IBatteryCellTemperatureListener {
    void batteryTemperatureChanged(double temperature, Object battery);
}
