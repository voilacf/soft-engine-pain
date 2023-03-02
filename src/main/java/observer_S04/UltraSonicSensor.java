package observer_S04;

import java.util.ArrayList;

public class UltraSonicSensor {
    private final int id;

    private final ArrayList<IUltraSonicSensorListener> listeners = new ArrayList<>();

    public UltraSonicSensor(int id) {
        this.id = id;
    }

    //Notify listeners about distance change
    public void distanceChanged(double distance) {
        for (IUltraSonicSensorListener listener : listeners) {
            listener.ultraSonicMeasurement(this, distance);
        }
    }

    public void addListener(IUltraSonicSensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IUltraSonicSensorListener listener) {
        listeners.remove(listener);
    }


    public void setDistance(double distance) {
        distanceChanged(distance);
    }

    public int getId() {
        return id;
    }
}
