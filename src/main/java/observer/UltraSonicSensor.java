package observer;
import java.util.ArrayList;

public class UltraSonicSensor {
    private double distance = 0.0;
    private final int id;

    private final ArrayList<IUltraSonicSensorListener> listeners = new ArrayList<>();


    public UltraSonicSensor(int id) {
        this.id = id;
    }


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
        this.distance = distance;
        distanceChanged(distance);
    }

    public int getId() {
        return id;
    }
}
