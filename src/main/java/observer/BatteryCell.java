package observer;

import java.util.ArrayList;

public class BatteryCell {
    private boolean energy;
    private ArrayList<IBatteryCellTemperatureListener> listeners;

    public BatteryCell() {
        listeners = new ArrayList<>();
    }

}
