package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.ElectricEngineState;
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

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventEngineOn event) {
        ElectricEngineState result = (ElectricEngineState) ComponentUtils.invokeMethod(engine, "on");
        System.out.println("receive -> electric-engine | state : " + result);
    }

    @Subscribe
    public void receive(EventEngineOff event) {
        ElectricEngineState result = (ElectricEngineState) ComponentUtils.invokeMethod(engine, "off");
        System.out.println("receive -> electric-engine | state : " + result);
    }

    @Subscribe
    public void receive(EventEngineIncreaseRPM event) {
        Integer result = (Integer) ComponentUtils.invokeMethod(engine, "increaseRPM", new Class[]{Integer.class}, event.getDeltaRPM());
        System.out.println("receive -> electric-engine | rpm : " + result);
    }

    @Subscribe
    public void receive(EventEngineDecreaseRPM event) {
        Integer result = (Integer) ComponentUtils.invokeMethod(engine, "decreaseRPM", new Class[]{Integer.class}, event.getDeltaRPM());
        System.out.println("receive -> electric-engine | rpm : " + result);
    }
}
