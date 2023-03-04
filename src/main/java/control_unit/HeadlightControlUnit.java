package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventLEDDimmed;
import events.EventLEDOff;
import events.EventLEDOn;
import events.EventLedHighBeam;

import java.lang.reflect.Method;

public class HeadlightControlUnit extends Subscriber {
    private final Object[] leds;

    public HeadlightControlUnit(Object[] leds) {
        super(7);
        this.leds = leds;
    }

    @Subscribe
    public void receive(EventLEDOn event) {
        for (Object led:leds
             ) {
            try {
                Method onMethod = led.getClass().getDeclaredMethod("on");
                onMethod.invoke(led);
                String result = (String) led.getClass().getDeclaredMethod("getState").invoke(led);
                System.out.println("receive -> led  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventLEDOff event) {
        for (Object led:leds
             ) {
            try {
                Method onMethod = led.getClass().getDeclaredMethod("off");
                onMethod.invoke(led);
                String result = (String) led.getClass().getDeclaredMethod("getState").invoke(led);
                System.out.println("receive -> led  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //TODO: add methods to diagram
    @Subscribe
    public void receive(EventLedHighBeam event) {
        for (Object led:leds
        ) {
            try {
                Method onMethod = led.getClass().getDeclaredMethod("beam");
                onMethod.invoke(led);
                String result = (String) led.getClass().getDeclaredMethod("getState").invoke(led);
                System.out.println("receive -> led  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventLEDDimmed event) {
        for (Object led:leds
        ) {
            try {
                Method onMethod = led.getClass().getDeclaredMethod("dimm");
                onMethod.invoke(led);
                String result = (String) led.getClass().getDeclaredMethod("getState").invoke(led);
                System.out.println("receive -> led  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
