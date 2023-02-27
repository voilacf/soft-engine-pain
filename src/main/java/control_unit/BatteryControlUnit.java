package control_unit;

import charging_station.EventCharging;
import com.google.common.eventbus.Subscribe;
import factories.ComponentFactory;

public class BatteryControlUnit extends Subscriber {
    private final Object batteryPort;

    public BatteryControlUnit() {
        super(1);
        batteryPort = ComponentFactory.buildBattery();
    }

    @Subscribe
    public void receive(EventCharging event){
        ControlUnitUtils.invokeMethod(batteryPort,"storeEnergy", new Class[]{Integer.class}, event.getAmountOfEnergy());
    }

}
