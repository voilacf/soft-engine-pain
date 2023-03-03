package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.BrakeLightState;
import events.EventBrakeLightOff;
import events.EventBrakeLightOn;

public class BrakeLightControlUnit extends Subscriber {
    private final Object[] brakeLights;

    public BrakeLightControlUnit(Object[] brakeLights) {
        super(3);
        this.brakeLights = brakeLights;
    }

    //TODO: remove event as parameter, or add getState to events?
    @Subscribe
    public void receive(EventBrakeLightOn event) {
        for (Object brakeLight : brakeLights) {
            BrakeLightState result = (BrakeLightState) ComponentUtils.invokeMethod(brakeLight, "on");
            System.out.println("receive -> brake light | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {
        for (Object brakeLight : brakeLights) {
            BrakeLightState result = (BrakeLightState) ComponentUtils.invokeMethod(brakeLight, "off");
            System.out.println("receive -> brake light | state : " + result);
        }
    }
}
