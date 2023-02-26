package control_unit;

import factories.ComponentFactory;

public class BatteryControlUnit extends Subscriber {
    private final Object batteryPort;

    public BatteryControlUnit() {
        super(1);
        batteryPort = ComponentFactory.buildBattery();
    }

}
