package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventBrakeLightOff;
import events.EventBrakeLightOn;

import java.lang.reflect.Method;

public class BrakeLightControlUnit extends Subscriber {
    private final Object[] brakeLights;

    public BrakeLightControlUnit(Object[] brakeLights) {
        super(3);
        this.brakeLights = brakeLights;
    }

    @Subscribe
    public void receive(EventBrakeLightOn event) {
        for (Object brakelight:brakeLights
             ) {
            try {
                Method onMethod = brakelight.getClass().getDeclaredMethod("on");
                onMethod.invoke(brakelight);
                String result = (String) brakelight.getClass().getDeclaredMethod("getState").invoke(brakelight);
                System.out.println("receive -> brake light  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {
        for (Object brakeLight:brakeLights
             ) {
            try {
                Method onMethod = brakeLight.getClass().getDeclaredMethod("off");
                onMethod.invoke(brakeLight);
                String result = (String) brakeLight.getClass().getDeclaredMethod("getState").invoke(brakeLight);
                System.out.println("receive -> brake light  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
