import java.lang.reflect.InvocationTargetException;

public class GPS {
    private static final GPS instance = new GPS();
    public Port port;
    private GPSState state;
    private String frequency;

    private GPS() {
        port = new Port();
    }

    public static GPS getInstance() {
        return instance;
    }

    private void innerOn() {
        state = GPSState.ON;
    }

    private void innerOff() {
        state = GPSState.OFF;
    }

    private void innerConnectSatellite(String frequency) {
        this.frequency = frequency;
    }

    private GPSState innerGetState() {
        return state;
    }

    private String innerGetFrequency() {
        return frequency;
    }

    public class Port implements IGPS {
        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public void connectSatellite(String frequency) {
            innerConnectSatellite(frequency);
        }

        @Override
        public String getState() {
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public String getFrequency() {
            return innerGetFrequency();
        }

        @Override
        public void accept(Object visitor) {
            try {
                visitor.getClass().getMethod("visitGps", Object.class).invoke(visitor, this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
