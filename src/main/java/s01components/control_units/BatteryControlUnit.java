package s01components.control_units;

import s06chargingstation.EventCharging;
import com.google.common.eventbus.Subscribe;
import s01components.ComponentFactory;

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
