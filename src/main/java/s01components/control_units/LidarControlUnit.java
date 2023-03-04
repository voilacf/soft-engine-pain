package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventLidarOff;
import s01components.events.EventLidarOn;

public class LidarControlUnit extends Subscriber {
    private final Object[] lidars;

    public LidarControlUnit(Object[] lidars) {
        super(9);
        this.lidars = lidars;
    }

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
