import java.util.ArrayList;

public class BatteryCell extends BatteryUnit {
    private final ArrayList<IBatteryCellTemperatureListener> listeners = new ArrayList<>();
    private boolean energy = true;

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
        if (energy) {
            // Already one energy stored, cannot store any more
            return 0;
        } else {
            // No energy stored, store one
            energy = true;
            temperatureChanged();
            return 1;
        }
    }

    //Add a listener to the battery cell temperature sensor
    public void addListener(Object listener) {
        listeners.add(new BatteryCellTemperatureListenerProxy(listener));
    }


    //Set a random temperature when the energy is used or stored
    private void temperatureChanged() {
        // Random temp between 25 and 55
        double temperature = 25 + Math.random() * 30;

        for (IBatteryCellTemperatureListener listener : listeners) {
            listener.batteryTemperatureChanged(temperature, this);
        }
    }
}
