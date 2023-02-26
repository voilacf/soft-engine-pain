package control_unit;

import application.CameraComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.CameraState;
import events.EventCameraOff;
import events.EventCameraOn;
import factories.ComponentFactory;

public class CameraControlUnit extends Subscriber {
    private final Object[] cameras;

    public CameraControlUnit(Object[] cameras) {
        super(1);
        this.cameras = cameras;
    }

    //TODO: remove event as parameter, or add getState to events?
    @Subscribe
    public void receive(EventCameraOn event) {
        for (Object camera : cameras) {
            CameraState result = (CameraState) ControlUnitUtils.invokeMethod(camera, "on");
            System.out.println("receive -> camera | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventCameraOff event) {
        for (Object camera : cameras) {
            CameraState result = (CameraState) ControlUnitUtils.invokeMethod(camera, "off");
            System.out.println("receive -> camera | state : " + result);
        }
    }

}
