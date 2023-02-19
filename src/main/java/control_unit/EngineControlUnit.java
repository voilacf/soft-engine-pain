package control_unit;

import application.EngineComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.ElectricEngineState;
import events.EventEngineDecreaseRPM;
import events.EventEngineIncreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;
import factories.Factory;

import java.lang.reflect.Method;

public class EngineControlUnit extends Subscriber {
    private final Object enginePort;

    //TODO: add parameters to constructor to decide which Engine version is to be build
    public EngineControlUnit(EngineComponentType type) {
        super(1);
        enginePort = Factory.buildEngine(type);
    }

    private void invokeMethod(Object engine, String engineMethod) {
        try {
            Method m = engine.getClass().getMethod(engineMethod);
            m.invoke(engine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventEngineOn engine) {
        try {
            Method onMethod = enginePort.getClass().getDeclaredMethod("on");
            ElectricEngineState result = (ElectricEngineState) onMethod.invoke(enginePort);
            System.out.println("receive -> electric-engine | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventEngineOff engine) {
        try {
            Method onMethod = enginePort.getClass().getDeclaredMethod("off");
            ElectricEngineState result = (ElectricEngineState) onMethod.invoke(enginePort);
            System.out.println("receive -> electric-engine | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventEngineIncreaseRPM engine) {
        try {
            Method onMethod = enginePort.getClass().getDeclaredMethod("increaseRPM");
            int result = (int) onMethod.invoke(enginePort);
            System.out.println("receive -> electric-engine | rpm : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventEngineDecreaseRPM engine) {
        try {
            Method onMethod = enginePort.getClass().getDeclaredMethod("decreaseRPM");
            int result = (int) onMethod.invoke(enginePort);
            System.out.println("receive -> electric-engine | rpm : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
