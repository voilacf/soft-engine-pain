package control_unit;

import application.LidarComponentType;
import com.google.common.eventbus.Subscribe;
import control_unit.states.LidarState;
import events.EventLidarOff;
import events.EventLidarOn;
import factories.ComponentFactory;

public class LidarControlUnit extends Subscriber {
    private final Object[] lidars;

    public LidarControlUnit(Object[] lidars) {
        super(1);
        this.lidars = lidars;
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventLidarOn event) {
        for (Object lidar : lidars) {
            LidarState result = (LidarState) ControlUnitUtils.invokeMethod(lidar, "on");
            System.out.println("receive -> lidar | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventLidarOff event) {
        for (Object lidar : lidars) {
            LidarState result = (LidarState) ControlUnitUtils.invokeMethod(lidar, "off");
            System.out.println("receive -> lidar | state : " + result);
        }
    }
}
