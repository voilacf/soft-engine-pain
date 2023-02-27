package door_button;

import components.VehicleKeyReceiverModule;

public class CommandEnable implements ICommand {
    private final VehicleKeyReceiverModule receiver;
    private final String encryptedPassword;

    public CommandEnable(VehicleKeyReceiverModule receiver, String encryptedPassword) {
        this.receiver = receiver;
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public void execute() {
        receiver.enableVehicle(encryptedPassword);
    }
}
