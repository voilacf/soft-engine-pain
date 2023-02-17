package control_unit;

import events.EventEngineIncreaseRPM;
import events.EventEngineDecreaseRPM;
import events.EventEngineOff;
import events.EventEngineOn;

public class EngineControlUnit extends Subscriber{
    //private IElectricEngine engine;

    public EngineControlUnit(){
        //TODO: Electric Engine Factory
        //this.engine = new ElectricEngine;
    }

    public void receive(EventEngineOn engine){

    }

    public void receive(EventEngineOff engine){

    }

    public void receive(EventEngineIncreaseRPM engine){

    }

    public void receive(EventEngineDecreaseRPM engine){

    }
}
