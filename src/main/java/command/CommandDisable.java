package command;

public class CommandDisable implements ICommand {
    private final VehicleKeyReceiverModule receiver;

    public CommandDisable(VehicleKeyReceiverModule receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.disableVehicle();
    }
}
