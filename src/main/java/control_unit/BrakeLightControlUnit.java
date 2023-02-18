package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventBrakeLightOff;
import events.EventBrakeLightOn;
import factories.BrakeLightFactory;

import java.lang.reflect.Method;

public class BrakeLightControlUnit extends Subscriber {
    private final Object brakeLightPort;

    public BrakeLightControlUnit() {
        super(1);
        brakeLightPort = BrakeLightFactory.build();
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

    }

    @Subscribe
    public void receive(EventBrakeLightOff event) {

    }
}
