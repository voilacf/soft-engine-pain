package observer;

import door_button.ICommand;

import java.util.ArrayList;

public class BatteryCell {
    private boolean energy;


    private final ArrayList<IBatteryCellTemperatureListener> listeners = new ArrayList<>();

        //Todo hier muss doch noch funktion vom T&emperatursensor rein oder?

    //Todo was soll da geprinted werden???
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
