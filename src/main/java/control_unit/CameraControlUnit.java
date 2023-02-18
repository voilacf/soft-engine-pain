package control_unit;

//import com.google.common.eventbus.Subscribe;
import events.EventCameraOff;
import events.EventCameraOn;
import factories.CameraFactory;

import java.lang.reflect.Method;

public class CameraControlUnit extends Subscriber{
    private final Object cameraPort;

    //TODO: add parameters to constructor to decide which Camera version is to be build
    public CameraControlUnit(){
        super(1);
        cameraPort = CameraFactory.build();
    }

    private void invokeMethod(Object brakelight, String brakelightMethod) {
        try{
            Method m = brakelight.getClass().getMethod(brakelightMethod);
            m.invoke(brakelight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Subscriber
    public void receive(EventCameraOn event){

    }

    //@Subscriber
    public void receive(EventCameraOff event){

    }

}
