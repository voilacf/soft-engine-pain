package control_unit;

import events.EventGPSConnectSatellite;
import events.EventGPSOff;
import events.EventGPSOn;

public class GPSControlUnit extends Subscriber{
    //private IGPS gps;

    public GPSControlUnit(){
        //TODO: gps factory
    }

    public void receive(EventGPSOn event){

    }

    public void receive(EventGPSOff event){

    }

    public void receive(EventGPSConnectSatellite event){

    }
}
