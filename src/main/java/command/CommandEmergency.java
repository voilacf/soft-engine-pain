package command;

import service_center.ServiceCenter;

public class CommandEmergency implements ICommand {
    private final ServiceCenter serviceCenter;

    public CommandEmergency(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public void execute() {
        // TODO: implement
    }
}
