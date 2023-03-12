package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventBrakeSet;

public class BrakeControlUnit extends Subscriber {
    private final Object[] brakes;

    public BrakeControlUnit(Object[] brakes) {
        super(2);
        this.brakes = brakes;
    }

    @Subscribe
    public void receive(EventBrakeSet event) {
        for (Object brake : brakes) {
            Double result = (Double) ComponentUtils.invokeMethod(brake, "setBrake", new Class[]{double.class}, event.getPercentage());
            System.out.println("receive -> setBrake  | percentage : " + event.getPercentage());
        }
    }
}
