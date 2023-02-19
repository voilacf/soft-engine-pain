package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventBrakeSet;
import factories.Factory;

public class BrakeControlUnit extends Subscriber {
    private final Object brakePort;

    public BrakeControlUnit() {
        super(1);
        brakePort = Factory.buildBrake();
    }

    @Subscribe
    public void receive(EventBrakeSet event) {
        Double result = (Double) ControlUnitUtils.invokeMethod(brakePort,"setBrake", new Class[]{Double.class}, event.getPercentage());
        System.out.println("receive -> setBrake  | percentage : " + result);
    }
}
