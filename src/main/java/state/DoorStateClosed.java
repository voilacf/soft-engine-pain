package state;

import components.Door;
import components.IDoorState;

public class DoorStateClosed implements IDoorState {
    @Override
    public void toggle(Door door) {
        door.setState(new DoorStateOpened());
    }
}
