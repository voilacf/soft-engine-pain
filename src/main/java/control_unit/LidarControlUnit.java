package control_unit;

import events.EventLidarOff;
import events.EventLidarOn;

public class LidarControlUnit extends Subscriber{
    //private ILidar lidar

    public LidarControlUnit(){
        //TODO: lidar factory
    }

    public void receive(EventLidarOn event){

    }

    public void receive(EventLidarOff event){

    }
}
