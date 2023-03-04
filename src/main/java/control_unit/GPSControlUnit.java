package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventGPSConnectSatellite;
import events.EventGPSOff;
import events.EventGPSOn;

import java.lang.reflect.Method;

public class GPSControlUnit extends Subscriber {
    private final Object[] gps;

    public GPSControlUnit(Object[] gps) {
        super(6);
        this.gps = gps;
    }

    @Subscribe
    public void receive(EventGPSOn event) {
        for (Object o :gps
             ) {
            try {
                Method onMethod = o.getClass().getDeclaredMethod("on");
                onMethod.invoke(o);
                String result = (String) o.getClass().getDeclaredMethod("getState").invoke(o);
                System.out.println("receive -> gps  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Subscribe
    public void receive(EventGPSOff event) {
        for (Object o:gps
             ) {
            try {
                Method onMethod = o.getClass().getDeclaredMethod("off");
                onMethod.invoke(o);
                String result = (String) o.getClass().getDeclaredMethod("getState").invoke(o);
                System.out.println("receive -> gps  | state : " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
