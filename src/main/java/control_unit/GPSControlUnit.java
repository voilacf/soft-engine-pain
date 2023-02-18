package control_unit;

import com.google.common.eventbus.Subscribe;
import events.EventGPSConnectSatellite;
import events.EventGPSOff;
import events.EventGPSOn;
import factories.GPSFactory;

import java.lang.reflect.Method;

public class GPSControlUnit extends Subscriber{
    private final Object gpsPort;

    public GPSControlUnit(){
        super(1);
        gpsPort = GPSFactory.build();
    }

    private void invokeMethod(Object gps, String gpsMethod) {
        try{
            Method m = gps.getClass().getMethod(gpsMethod);
            m.invoke(gps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(EventGPSOn event){

    }

    @Subscribe
    public void receive(EventGPSOff event){

    }

    @Subscribe
    public void receive(EventGPSConnectSatellite event){

    }
}
