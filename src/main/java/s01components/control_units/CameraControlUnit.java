package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventCameraOff;
import s01components.events.EventCameraOn;

import java.lang.reflect.Method;

public class CameraControlUnit extends Subscriber {
    private final Object[] cameras;

    public CameraControlUnit(Object[] cameras) {
        super(4);
        this.cameras = cameras;
    }

    @Subscribe
    public void receive(EventCameraOn event) {
        for (Object camera : cameras
        ) {
            try {
                Method onMethod = camera.getClass().getDeclaredMethod("on");
                onMethod.invoke(camera);
                String result = (String) camera.getClass().getDeclaredMethod("getState").invoke(camera);
                System.out.println("receive -> camera  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventCameraOff event) {
        for (Object camera : cameras
        ) {
            try {
                Method onMethod = camera.getClass().getDeclaredMethod("off");
                onMethod.invoke(camera);
                String result = (String) camera.getClass().getDeclaredMethod("getState").invoke(camera);
                System.out.println("receive -> camera  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
