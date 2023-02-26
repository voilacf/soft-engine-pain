package control_unit;

import application.CameraComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.CameraState;
import events.EventCameraOff;
import events.EventCameraOn;
import factories.ComponentFactory;

public class CameraControlUnit extends Subscriber {
    private final Object cameraPort;

    public CameraControlUnit(CameraComponentType type) {
        super(1);
        cameraPort = ComponentFactory.buildCamera(type);
    }

    //TODO: remove event as parameter, or add getState to events?
    @Subscribe
    public void receive(EventCameraOn event) {
        CameraState result = (CameraState) ControlUnitUtils.invokeMethod(cameraPort,"on");
        System.out.println("receive -> camera | state : " + result);
    }

    @Subscribe
    public void receive(EventCameraOff event) {
        CameraState result = (CameraState) ControlUnitUtils.invokeMethod(cameraPort,"off");
        System.out.println("receive -> camera | state : " + result);
    }

}
