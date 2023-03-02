package state_S04;

import observer_S04.Door;

public class DoorStateOpened implements IDoorState {
    @Override
    public void toggle(Door door) {
        System.out.println("Toggling door from opened to closed");
        door.setState(new DoorStateClosed());
    }
}
