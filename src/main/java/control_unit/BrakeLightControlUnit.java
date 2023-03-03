package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventBrakeLightOff;
import events.EventBrakeLightOn;

public class BrakeLightControlUnit extends Subscriber {
    private final Object[] brakeLights;

    public BrakeLightControlUnit(Object[] brakeLights) {
        super(3);
        this.brakeLights = brakeLights;
    }

    @Subscribe
    public void receive(EventBrakeLightOn event) {
        for (Object brakeLight : brakeLights) {
            Object result = ComponentUtils.invokeMethod(brakeLight, "on");
            System.out.println("receive -> brake light | state : on");
        }
    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {
        for (Object brakeLight : brakeLights) {
            Object result = ComponentUtils.invokeMethod(brakeLight, "off");
            System.out.println("receive -> brake light | state : off");
        }
    }
}
