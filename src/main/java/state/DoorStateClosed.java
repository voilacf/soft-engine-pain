package state;

import components.Door;
import components.IDoorState;

public class DoorStateClosed implements IDoorState {
    @Override
    public void toggle(Door door) {
        System.out.println("Toggling door from closed to opened");
        door.setState(new DoorStateOpened());
    }
}
