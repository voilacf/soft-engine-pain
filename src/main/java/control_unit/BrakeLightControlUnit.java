package control_unit;

import events.EventBrakeLightOff;
import events.EventBrakeLightOn;


public class BrakeLightControlUnit extends Subscriber{
    //private IBrakeLight brakelight;

    public BrakeLightControlUnit(){
        //TODO: brakelight factory
    }

    public void receive(EventBrakeLightOn event){

    }

    public void receive(EventBrakeLightOff event){

    }
}
