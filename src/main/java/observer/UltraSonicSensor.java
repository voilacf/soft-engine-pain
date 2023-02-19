package observer;



import java.util.ArrayList;

public class UltraSonicSensor {
    private final ArrayList<IUltraSonicSensorListener> listeners = new ArrayList<>();

    //Todo hier muss doch noch funktion vom Ultrasonicsensor rein oder?

    public void addListener(IUltraSonicSensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IUltraSonicSensorListener listener) {
        listeners.remove(listener);
    }
}
