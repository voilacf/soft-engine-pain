package observer;

public interface IBatteryCellTemperatureListener {
    void batterytemperatureChanged(double temperature, Object battery);
}
