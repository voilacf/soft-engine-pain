import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ElectricEngineX {
    private static final ElectricEngineX instance = new ElectricEngineX();
    public Port port;
    private ElectricEngineState state;
    private int rpm = 0;
    private Object powerProvider; // bridge object to battery


    private ElectricEngineX() {
        port = new Port();
    }

    public static ElectricEngineX getInstance() {
        return instance;
    }

    private void innerOn() {
        state = ElectricEngineState.ON;
    }

    private void innerOff() {
        state = ElectricEngineState.OFF;
    }

    private void innerIncreaseRPM(int deltaRPM, int seconds) {
        rpm += deltaRPM;

        if (powerProvider == null)
            return;
        try {
            for (int i = 0; i < seconds; i++) {
                Method m = powerProvider.getClass().getMethod("simulateEnergyUsageSecond", int.class);
                m.invoke(powerProvider, rpm);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void innerDecreaseRPM(int deltaRPM, int seconds) {
        rpm -= deltaRPM;

        if (powerProvider == null)
            return;
        try {
            for (int i = 0; i < seconds; i++) {
                Method m = powerProvider.getClass().getMethod("simulateEnergyUsageSecond", int.class);
                m.invoke(powerProvider, rpm);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private ElectricEngineState innerGetState() {
        return this.state;
    }

    private int innergetPowerDrawPerRotation() {
        return 4;
    }

    private void innerSetPowerProvider(Object powerProvider) {
        this.powerProvider = powerProvider;
    }

    private int innerGetRPM() {
        return rpm;
    }

    public class Port implements IElectricEngine {
        @Override
        public int getRPM() {
            return innerGetRPM();
        }

        @Override
        public String getState() {
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public void increaseRPM(int deltaRPM, int seconds) {
            innerIncreaseRPM(deltaRPM, seconds);
        }

        @Override
        public void decreaseRPM(int deltaRPM, int seconds) {
            innerDecreaseRPM(deltaRPM, seconds);
        }

        @Override
        public int getPowerDrawPerRotation() {
            return innergetPowerDrawPerRotation();
        }

        @Override
        public void setPowerProvider(Object powerProvider) {
            innerSetPowerProvider(powerProvider);
        }
    }
}
