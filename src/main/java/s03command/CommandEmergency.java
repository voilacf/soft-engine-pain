package s03command;

import s05servicecenter.ServiceCenter;

public class CommandEmergency implements ICommand {
    private final ServiceCenter serviceCenter;

    public CommandEmergency(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public void execute() {
        serviceCenter.handleEmergency();
    }
}
