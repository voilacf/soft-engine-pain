package control_unit;

//import com.google.common.eventbus.Subscribe;
import events.EventEngineIncreaseRPM;
import events.EventEngineDecreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;
import factories.ElectricEngineFactory;

import java.lang.reflect.Method;

public class EngineControlUnit extends Subscriber{
    private final Object enginePort;

    //TODO: add parameters to constructor to decide which Engine version is to be build
    public EngineControlUnit(){
        super(1);
        enginePort = ElectricEngineFactory.build();
    }

    private void invokeMethod(Object engine, String engineMethod) {
        try{
            Method m = engine.getClass().getMethod(engineMethod);
            m.invoke(engine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Subscriber
    public void receive(EventEngineOn engine){

    }

    //@Subscriber
    public void receive(EventEngineOff engine){

    }

    //@Subscriber
    public void receive(EventEngineIncreaseRPM engine){

    }

    //@Subscriber
    public void receive(EventEngineDecreaseRPM engine){

    }
}
