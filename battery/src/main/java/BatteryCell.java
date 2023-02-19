import java.util.ArrayList;

public class BatteryCell extends BatteryUnit {
    private boolean energy = true;
    private double temperature = 0.0;

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


    public void setTemperature(double temperature) {
        this.temperature = temperature;
        for (IBatteryCellTemperatureListener listener : listeners) {
            listener.batterytemperatureChanged(temperature, this);
        }
    }

    public double getTemperature() {
        return temperature;
    }
}
