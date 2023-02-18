package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventBrakeSet;
import factories.BrakeFactory;

import java.lang.reflect.Method;

public class BrakeControlUnit extends Subscriber {
    private final Object brakePort;

    public BrakeControlUnit() {
        super(1);
        brakePort = BrakeFactory.build();
    }

    private void invokeMethod(Object brake, String brakeMethod) {
        try {
            Method m = brake.getClass().getMethod(brakeMethod);
            m.invoke(brake);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventBrakeSet event) {
        try {
            Method onMethod = brakePort.getClass().getDeclaredMethod("open");
            //DoorState result = (DoorState) onMethod.invoke(brakePort);
            //System.out.println("receive -> doorOpen  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
