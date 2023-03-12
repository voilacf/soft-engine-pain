package s04state;

import s03command.Door;

public class DoorStateOpened implements IDoorState {
    @Override
    public void toggle(Door door) {
        System.out.println("Toggling door from opened to closed");
        door.setState(new DoorStateClosed());
    }
}
