package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventLEDOff;
import events.EventLEDOn;
import factories.LEDHeadLightFactroy;

import java.lang.reflect.Method;

public class LEDControlUnit extends Subscriber {
    private final Object ledPort;

    public LEDControlUnit() {
        super(1);
        ledPort = LEDHeadLightFactroy.build();
    }

    private void invokeMethod(Object led, String ledMethod) {
        try {
            Method m = led.getClass().getMethod(ledMethod);
            m.invoke(led);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventLEDOn event) {

    }

    @Subscribe
    public void receive(EventLEDOff event) {

    }
}
