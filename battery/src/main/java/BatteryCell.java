import java.util.ArrayList;

public class BatteryCell extends BatteryUnit {
    private boolean energy = true;

    private final ArrayList<IBatteryCellTemperatureListener> listeners = new ArrayList<>();

    public BatteryCell(BatteryUnit parentUnit) {
        super(parentUnit);
    }

    @Override
    public void printBatterySummary() {
        System.out.println("Battery cell is " + (energy ? "full" : "empty"));
    }

    @Override
    public int getEnergyCount() {
        return energy ? 1 : 0;
    }

    @Override
    public int useEnergyCount(int count) {
        if (energy) {
            // Energy is available, use it
            energy = false;
            return 1;
        } else {
            // No energy available that could be used
            return 0;
        }
    }

    public void addListener(IBatteryCellTemperatureListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IBatteryCellTemperatureListener listener) {
        listeners.remove(listener);
    }

    public void temperatureChanged(double temperature) {
        for (IBatteryCellTemperatureListener listener : listeners) {
            listener.batteryTemperatureChanged(temperature, this);
        }
    }

    public void setTemperature(double temperature) {
        temperatureChanged(temperature);
    }
}
