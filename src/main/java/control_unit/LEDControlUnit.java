package control_unit;

import events.EventLEDOff;
import events.EventLEDOn;

public class LEDControlUnit extends Subscriber{
    //private ILED led;

    public LEDControlUnit(){
        //TODO: led factory
        //led = new LED();
    }

    public void receive(EventLEDOn event){

    }

    public void receive(EventLEDOff event){

    }
}
