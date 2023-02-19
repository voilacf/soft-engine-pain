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

    private void invokeMethod(Object brakelight, String brakelightMethod) {
        try {
            Method m = brakelight.getClass().getMethod(brakelightMethod);
            m.invoke(brakelight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventBrakeLightOn event) {
        try {
            Method onMethod = brakeLightPort.getClass().getDeclaredMethod("on");
            BrakeLightState result = (BrakeLightState) onMethod.invoke(brakeLightPort);
            System.out.println("receive -> brake light | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {
        try {
            Method onMethod = brakeLightPort.getClass().getDeclaredMethod("off");
            BrakeLightState result = (BrakeLightState) onMethod.invoke(brakeLightPort);
            System.out.println("receive -> brake light  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
