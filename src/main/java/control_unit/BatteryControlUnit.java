package control_unit;

import factories.BatteryFactory;

import java.lang.reflect.Method;

public class BatteryControlUnit extends Subscriber {
    private final Object batteryPort;

    public BatteryControlUnit() {
        super(1);
        batteryPort = BatteryFactory.build();
    }

    private void invokeMethod(Object battery, String batteryMethod) {
        try {
            Method m = battery.getClass().getMethod(batteryMethod);
            m.invoke(battery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
