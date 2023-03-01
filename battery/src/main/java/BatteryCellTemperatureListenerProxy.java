import java.lang.reflect.Method;

public class BatteryCellTemperatureListenerProxy implements IBatteryCellTemperatureListener {
    private final Object listener;

    public BatteryCellTemperatureListenerProxy(Object listener) {
        this.listener = listener;
    }

    @Override
    public void batteryTemperatureChanged(double temperature, BatteryCell battery) {
        try {
            Method changedMethod = listener.getClass().getMethod("batteryTemperatureChanged", double.class, Object.class);
            changedMethod.invoke(listener, temperature, battery);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
