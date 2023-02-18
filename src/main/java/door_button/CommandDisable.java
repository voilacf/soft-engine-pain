package door_button;

import components.VehicleKey;

public class CommandDisable implements ICommand {
    private final VehicleKey key;

    public CommandDisable(VehicleKey key) {
        this.key = key;
    }

    @Override
    public void execute() {
        key.disableVehicle();
    }
}
