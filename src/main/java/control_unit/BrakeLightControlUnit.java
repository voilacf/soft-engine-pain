package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.BrakeLightState;
import events.EventBrakeLightOff;
import events.EventBrakeLightOn;
import factories.Factory;

import java.lang.reflect.Method;

public class BrakeLightControlUnit extends Subscriber {
    private final Object brakeLightPort;

    public BrakeLightControlUnit() {
        super(1);
        brakeLightPort = Factory.buildBrakeLight();
    }

    //TODO: remove event as parameter, or add getState to events?
    @Subscribe
    public void receive(EventBrakeLightOn event) {
        BrakeLightState result = (BrakeLightState) ControlUnitUtils.invokeMethod(brakeLightPort, "on");
        System.out.println("receive -> brake light | state : " + result);
    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {
        BrakeLightState result = (BrakeLightState) ControlUnitUtils.invokeMethod(brakeLightPort, "off");
        System.out.println("receive -> brake light  | state : " + result);

    }
}
