package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventEngineDecreaseRPM;
import events.EventEngineIncreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;

import java.lang.reflect.Method;

public class EngineControlUnit extends Subscriber {
    private final Object engine;

    public EngineControlUnit(Object engine) {
        super(5);
        this.engine = engine;
    }

    @Subscribe
    public void receive(EventEngineOn event) {
        try {
            Method onMethod = engine.getClass().getDeclaredMethod("on");
            onMethod.invoke(engine);
            String result = (String) engine.getClass().getDeclaredMethod("getState").invoke(engine);
            System.out.println("receive -> electric engine  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventEngineOff event) {
        try {
            Method onMethod = engine.getClass().getDeclaredMethod("off");
            onMethod.invoke(engine);
            String result = (String) engine.getClass().getDeclaredMethod("getState").invoke(engine);
            System.out.println("receive -> electric engine  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
