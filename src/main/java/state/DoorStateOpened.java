package state;

import components.Door;
import components.IDoorState;

public class DoorStateOpened implements IDoorState {
    @Override
    public void toggle(Door door) {
        System.out.println("Toggling door from opened to closed");
        door.setState(new DoorStateClosed());
    }
}
