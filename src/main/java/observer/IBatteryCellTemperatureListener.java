package observer;

public interface IBatteryCellTemperatureListener {
    void batterytemperatureChanged(double temperature, BatteryCell battery);
}
