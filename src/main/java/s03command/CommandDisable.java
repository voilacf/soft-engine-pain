package s03command;

public class CommandDisable implements ICommand {
    private final VehicleKeyReceiverModule receiver;
    private final String encryptedPassword;

    public CommandDisable(VehicleKeyReceiverModule receiver, String encryptedPassword) {
        this.receiver = receiver;
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public void execute() {
        receiver.disableVehicle(encryptedPassword);
    }
}
