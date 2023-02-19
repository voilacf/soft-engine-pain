package observer;

import door_button.ICommand;

import java.util.ArrayList;

public class BatteryCell {
    private boolean energy;


    private final ArrayList<IBatteryCellTemperatureListener> listeners = new ArrayList<>();

    // TODO: hier muss doch noch funktion vom T&emperatursensor rein oder?
    // TODO: merge with version of battery component

    public void printBatterySummary() {
        System.out.println("Battery summary:");
        System.out.println("Energy: " + energy);
    }


    public void addListener(IBatteryCellTemperatureListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IBatteryCellTemperatureListener listener) {
        listeners.remove(listener);
    }

}
