package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventEngineDecreaseRPM;
import events.EventEngineIncreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;

public class EngineControlUnit extends Subscriber {
    private final Object engine;

    public EngineControlUnit(Object engine) {
        super(5);
        this.engine = engine;
    }

    @Subscribe
    public void receive(EventEngineOn event) {
        Object result = ComponentUtils.invokeMethod(engine, "on");
        System.out.println("receive -> electric-engine | state : on");
    }

    @Subscribe
    public void receive(EventEngineOff event) {
        Object result = ComponentUtils.invokeMethod(engine, "off");
        System.out.println("receive -> electric-engine | state : off");
    }

    @Subscribe
    public void receive(EventEngineIncreaseRPM event) {
        Integer result = (Integer) ComponentUtils.invokeMethod(engine, "increaseRPM", new Class[]{int.class,int.class}, event.getDeltaRPM(),event.getSeconds());
        System.out.println("receive -> electric-engine | rpm : " + event.getDeltaRPM());
    }

    @Subscribe
    public void receive(EventEngineDecreaseRPM event) {
        Integer result = (Integer) ComponentUtils.invokeMethod(engine, "decreaseRPM", new Class[]{int.class,int.class}, event.getDeltaRPM(),event.getSeconds());
        System.out.println("receive -> electric-engine | rpm : " + event.getDeltaRPM());
    }
}
