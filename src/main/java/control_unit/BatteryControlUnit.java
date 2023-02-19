package control_unit;

import factories.Factory;

import java.lang.reflect.Method;

public class BatteryControlUnit extends Subscriber {
    private final Object batteryPort;

    public BatteryControlUnit() {
        super(1);
        batteryPort = Factory.buildBattery();
    }

}
