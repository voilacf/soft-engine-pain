package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventLidarOff;
import s01components.events.EventLidarOn;

import java.lang.reflect.Method;

public class LidarControlUnit extends Subscriber {
    private final Object[] lidars;

    public LidarControlUnit(Object[] lidars) {
        super(9);
        this.lidars = lidars;
    }

    @Subscribe
    public void receive(EventLidarOn event) {
        for (Object lidar : lidars
        ) {
            try {
                Method onMethod = lidar.getClass().getDeclaredMethod("on");
                onMethod.invoke(lidar);
                String result = (String) lidar.getClass().getDeclaredMethod("getState").invoke(lidar);
                System.out.println("receive -> lidar  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventLidarOff event) {
        for (Object lidar : lidars
        ) {
            try {
                Method onMethod = lidar.getClass().getDeclaredMethod("off");
                onMethod.invoke(lidar);
                String result = (String) lidar.getClass().getDeclaredMethod("getState").invoke(lidar);
                System.out.println("receive -> lidar  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
