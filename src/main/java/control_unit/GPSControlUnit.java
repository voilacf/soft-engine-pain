package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.GPSState;
import events.EventGPSConnectSatellite;
import events.EventGPSOff;
import events.EventGPSOn;
import factories.Factory;

import java.lang.reflect.Method;

public class GPSControlUnit extends Subscriber {
    private final Object gpsPort;

    public GPSControlUnit() {
        super(1);
        gpsPort = Factory.buildGPS();
    }

    private void invokeMethod(Object gps, String gpsMethod) {
        try {
            Method m = gps.getClass().getMethod(gpsMethod);
            m.invoke(gps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventGPSOn event) {
        try {
            Method onMethod = gpsPort.getClass().getDeclaredMethod("on");
            GPSState result = (GPSState) onMethod.invoke(gpsPort);
            System.out.println("receive -> gps | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventGPSOff event) {
        try {
            Method onMethod = gpsPort.getClass().getDeclaredMethod("off");
            GPSState result = (GPSState) onMethod.invoke(gpsPort);
            System.out.println("receive -> gps | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventGPSConnectSatellite event) {
        try {
            Method onMethod = gpsPort.getClass().getDeclaredMethod("connectSatellite");
            String result = (String) onMethod.invoke(gpsPort);
            System.out.println("receive -> gps | frequency : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
