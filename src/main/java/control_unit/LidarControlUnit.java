package control_unit;

import application.LidarComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.LidarState;
import events.EventLidarOff;
import events.EventLidarOn;
import factories.Factory;

public class LidarControlUnit extends Subscriber {
    private final Object lidarPort;

    public LidarControlUnit(LidarComponentType type) {
        super(1);
        lidarPort = Factory.buildLidar(type);
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventLidarOn event) {
        LidarState result = (LidarState) ControlUnitUtils.invokeMethod(lidarPort, "on");
        System.out.println("receive -> lidar | state : " + result);
    }

    @Subscribe
    public void receive(EventLidarOff event) {
        LidarState result = (LidarState) ControlUnitUtils.invokeMethod(lidarPort,"off");
        System.out.println("receive -> lidar | state : " + result);
    }
}
