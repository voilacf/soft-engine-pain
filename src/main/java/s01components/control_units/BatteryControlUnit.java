package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.ComponentFactory;
import s06chargingstation.EventCharging;

public class BatteryControlUnit extends Subscriber {
    private final Object batteryPort;

    public BatteryControlUnit() {
        super(1);
        batteryPort = ComponentFactory.buildBattery();
    }

    @Subscribe
    public void receive(EventCharging event) {
        ComponentUtils.invokeMethod(batteryPort, "storeEnergy", new Class[]{int.class}, event.getAmountOfEnergy());
    }

}
