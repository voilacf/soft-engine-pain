package control_unit;

import application.EngineComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.ElectricEngineState;
import events.EventEngineDecreaseRPM;
import events.EventEngineIncreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;
import factories.Factory;

public class EngineControlUnit extends Subscriber {
    private final Object enginePort;

    public EngineControlUnit(EngineComponentType type) {
        super(1);
        enginePort = Factory.buildEngine(type);
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventEngineOn event) {
        ElectricEngineState result = (ElectricEngineState) ControlUnitUtils.invokeMethod(enginePort,"on");
        System.out.println("receive -> electric-engine | state : " + result);
    }

    @Subscribe
    public void receive(EventEngineOff event) {
        ElectricEngineState result = (ElectricEngineState) ControlUnitUtils.invokeMethod(enginePort, "off");
        System.out.println("receive -> electric-engine | state : " + result);
    }

    @Subscribe
    public void receive(EventEngineIncreaseRPM event) {
        Integer result = (Integer) ControlUnitUtils.invokeMethod(enginePort, "increaseRPM",new Class[]{Integer.class}, event.getDeltaRPM());
        System.out.println("receive -> electric-engine | rpm : " + result);
    }

    @Subscribe
    public void receive(EventEngineDecreaseRPM event) {
        Integer result = (Integer) ControlUnitUtils.invokeMethod(enginePort, "decreaseRPM",new Class[]{Integer.class}, event.getDeltaRPM());
        System.out.println("receive -> electric-engine | rpm : " + result);
    }
}
