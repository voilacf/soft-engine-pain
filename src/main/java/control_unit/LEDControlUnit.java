package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.BrakeLightState;
import control_unit.states.LEDState;
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
        try {
            Method onMethod = ledPort.getClass().getDeclaredMethod("on");
            LEDState result = (LEDState) onMethod.invoke(ledPort);
            System.out.println("receive -> led | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventLEDOff event) {
        try {
            Method onMethod = ledPort.getClass().getDeclaredMethod("off");
            LEDState result = (LEDState) onMethod.invoke(ledPort);
            System.out.println("receive -> led | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
