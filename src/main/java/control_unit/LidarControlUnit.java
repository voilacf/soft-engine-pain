package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventLidarOff;
import events.EventLidarOn;

public class LidarControlUnit extends Subscriber {
    private final Object[] lidars;

    public LidarControlUnit(Object[] lidars) {
        super(9);
        this.lidars = lidars;
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventLidarOn event) {
        for (Object lidar : lidars) {
            ComponentUtils.invokeMethod(lidar, "on");
            System.out.println("receive -> lidar | state : on");
        }
    }

    @Subscribe
    public void receive(EventLidarOff event) {
        for (Object lidar : lidars) {
            ComponentUtils.invokeMethod(lidar, "off");
            System.out.println("receive -> lidar | state : off");
        }
    }
}
