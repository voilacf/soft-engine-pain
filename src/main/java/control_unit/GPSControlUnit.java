package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.GPSState;
import events.EventGPSConnectSatellite;
import events.EventGPSOff;
import events.EventGPSOn;
import factories.ComponentFactory;

public class GPSControlUnit extends Subscriber {
    private final Object[] gps;

    public GPSControlUnit(Object[] gps) {
        super(1);
        this.gps = gps;
    }

    //TODO: remove event as parameter from first two methods, or add getState to events?
    @Subscribe
    public void receive(EventGPSOn event) {
        for (Object gpsPort : gps) {
            GPSState result = (GPSState) ControlUnitUtils.invokeMethod(gpsPort,"on");
            System.out.println("receive -> gps | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventGPSOff event) {
        for (Object gpsPort : gps) {
            GPSState result = (GPSState) ControlUnitUtils.invokeMethod(gpsPort, "off");
            System.out.println("receive -> gps | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventGPSConnectSatellite event) {
        for (Object gpsPort : gps) {
            String result = (String) ControlUnitUtils.invokeMethod(gpsPort, "connectSatellite",new Class[]{String.class},event.getFrequency());
            System.out.println("receive -> gps | frequency : " + result);
        }
    }
}
