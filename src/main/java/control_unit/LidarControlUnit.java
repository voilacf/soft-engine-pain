package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.BrakeLightState;
import control_unit.states.LidarState;
import events.EventLidarOff;
import events.EventLidarOn;
import factories.LidarFactory;

import java.lang.reflect.Method;

public class LidarControlUnit extends Subscriber {
    private final Object lidarPort;

    //TODO: add parameters to constructor to decide which Lidar version is to be build
    public LidarControlUnit() {
        super(1);
        lidarPort = LidarFactory.build();
    }

    private void invokeMethod(Object lidar, String lidarMethod) {
        try {
            Method m = lidar.getClass().getMethod(lidarMethod);
            m.invoke(lidar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventLidarOn event) {
        try {
            Method onMethod = lidarPort.getClass().getDeclaredMethod("on");
            LidarState result = (LidarState) onMethod.invoke(lidarPort);
            System.out.println("receive -> lidar | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventLidarOff event) {
        try {
            Method onMethod = lidarPort.getClass().getDeclaredMethod("off");
            LidarState result = (LidarState) onMethod.invoke(lidarPort);
            System.out.println("receive -> lidar | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
