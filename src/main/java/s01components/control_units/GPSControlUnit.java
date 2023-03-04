package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.EventGPSConnectSatellite;
import s01components.events.EventGPSOff;
import s01components.events.EventGPSOn;

public class GPSControlUnit extends Subscriber {
    private final Object[] gps;

    public GPSControlUnit(Object[] gps) {
        super(6);
        this.gps = gps;
    }

    @Subscribe
    public void receive(EventGPSOn event) {
        for (Object gpsPort : gps) {
            Object result = ComponentUtils.invokeMethod(gpsPort, "on");
            System.out.println("receive -> gps | state : on");
        }
    }

    @Subscribe
    public void receive(EventGPSOff event) {
        for (Object gpsPort : gps) {
            Object result = ComponentUtils.invokeMethod(gpsPort, "off");
            System.out.println("receive -> gps | state : off");
        }
    }

    @Subscribe
    public void receive(EventGPSConnectSatellite event) {
        for (Object gpsPort : gps) {
            ComponentUtils.invokeMethod(gpsPort, "connectSatellite", new Class[]{String.class}, event.getFrequency());
            System.out.println("receive -> gps | frequency : " + event.getFrequency());
        }
    }
}
