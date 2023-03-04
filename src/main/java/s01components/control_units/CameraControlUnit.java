package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventCameraOff;
import s01components.events.EventCameraOn;

public class CameraControlUnit extends Subscriber {
    private final Object[] cameras;

    public CameraControlUnit(Object[] cameras) {
        super(4);
        this.cameras = cameras;
    }

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
