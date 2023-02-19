package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.CameraState;
import events.EventCameraOff;
import events.EventCameraOn;
import factories.CameraFactory;

import java.lang.reflect.Method;

public class CameraControlUnit extends Subscriber {
    private final Object cameraPort;

    //TODO: add parameters to constructor to decide which Camera version is to be build
    public CameraControlUnit() {
        super(1);
        cameraPort = CameraFactory.build();
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
    public void receive(EventCameraOn event) {
        try {
            Method onMethod = cameraPort.getClass().getDeclaredMethod("on");
            CameraState result = (CameraState) onMethod.invoke(cameraPort);
            System.out.println("receive -> camera | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventCameraOff event) {
        try {
            Method onMethod = cameraPort.getClass().getDeclaredMethod("off");
            CameraState result = (CameraState) onMethod.invoke(cameraPort);
            System.out.println("receive -> camera | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
