package s03command;

public class CommandToggleDoor implements ICommand {
    private final Door door;

    public CommandToggleDoor(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.toggleDoorState();
    }
}
