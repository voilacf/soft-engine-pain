package door_button;

import components.VehicleKey;

public class CommandEnable implements ICommand {
    private final VehicleKey key;

    public CommandEnable(VehicleKey key) {
        this.key = key;
    }

    @Override
    public void execute() {
        key.enableVehicle();
    }
}
