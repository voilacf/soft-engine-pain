package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventCameraOff;
import events.EventCameraOn;

public class CameraControlUnit extends Subscriber {
    private final Object[] cameras;

    public CameraControlUnit(Object[] cameras) {
        super(4);
        this.cameras = cameras;
    }

    //TODO: remove event as parameter, or add getState to events?
    @Subscribe
    public void receive(EventCameraOn event) {
        for (Object camera : cameras) {
            Object result = ComponentUtils.invokeMethod(camera, "on");
            System.out.println("receive -> camera | state : on");
        }
    }

    @Subscribe
    public void receive(EventCameraOff event) {
        for (Object camera : cameras) {
            Object result = ComponentUtils.invokeMethod(camera, "off");
            System.out.println("receive -> camera | state : off");
        }
    }

}
