package command;

public class CommandEnable implements ICommand {
    private final VehicleKeyReceiverModule receiver;

    public CommandEnable(VehicleKeyReceiverModule receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // TODO: implement
    }
}
