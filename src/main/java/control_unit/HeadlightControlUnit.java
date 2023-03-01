package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.LEDState;
import events.EventLEDOff;
import events.EventLEDOn;

public class HeadlightControlUnit extends Subscriber {
    private final Object[] leds;

    public HeadlightControlUnit(Object[] leds) {
        super(7);
        this.leds = leds;
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventLEDOn event) {
        for (Object ledPort : leds) {
            LEDState result = (LEDState) ComponentUtils.invokeMethod(ledPort,"on");
            System.out.println("receive -> led | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventLEDOff event) {
        for (Object ledPort : leds) {
            LEDState result = (LEDState) ComponentUtils.invokeMethod(ledPort, "off");
            System.out.println("receive -> led | state : " + result);
        }
    }
}
