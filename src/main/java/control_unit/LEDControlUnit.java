package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.LEDState;
import events.EventLEDOff;
import events.EventLEDOn;
import factories.ComponentFactory;

public class LEDControlUnit extends Subscriber {
    private final Object ledPort;

    public LEDControlUnit() {
        super(1);
        ledPort = ComponentFactory.buildLED();
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventLEDOn event) {
        LEDState result = (LEDState) ControlUnitUtils.invokeMethod(ledPort,"on");
        System.out.println("receive -> led | state : " + result);
    }

    @Subscribe
    public void receive(EventLEDOff event) {
        LEDState result = (LEDState) ControlUnitUtils.invokeMethod(ledPort, "off");
        System.out.println("receive -> led | state : " + result);
    }
}
