package control_unit;

import application.LidarComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.LidarState;
import events.EventLidarOff;
import events.EventLidarOn;
import factories.Factory;

import java.lang.reflect.Method;

public class LidarControlUnit extends Subscriber {
    private final Object lidarPort;

    public LidarControlUnit(LidarComponentType type) {
        super(1);
        lidarPort = Factory.buildLidar(type);
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
