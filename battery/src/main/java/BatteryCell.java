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
    public int getEnergy() {
        return energy ? 1 : 0;
    }

    @Override
    public int useEnergy(int count) {
        if (energy) {
            // Energy is available, use it
            energy = false;
            temperatureChanged();
            return 1;
        } else {
            // No energy available that could be used
            return 0;
        }
    }

    @Override
    public int storeEnergy(int count) {
        if(energy) {
            // Already one energy stored, cannot store any more
            return 0;
        } else {
            // No energy stored, store one
            energy = true;
            temperatureChanged();
            return 1;
        }
    }

    public void addListener(IBatteryCellTemperatureListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IBatteryCellTemperatureListener listener) {
        listeners.remove(listener);
    }

    private void temperatureChanged() {
        // Random temp between 25 and 55
        double temperature = 25 + Math.random() * 30;

        for (IBatteryCellTemperatureListener listener : listeners) {
            listener.batteryTemperatureChanged(temperature, this);
        }
    }
}
