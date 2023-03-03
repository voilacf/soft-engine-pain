package state_S04;

import observer_S04.Door;

public class DoorStateClosed implements IDoorState {
    @Override
    public void toggle(Door door) {
        System.out.println("Toggling door from closed to opened");
        door.setState(new DoorStateOpened());
    }
}
