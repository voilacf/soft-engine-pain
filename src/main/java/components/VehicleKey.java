package components;

import command.Button;
import command.CommandEnable;
import command.VehicleKeyReceiverModule;

public class VehicleKey {
    // TODO: implement password check in receiver
    private final String encryptedPassword;
    private final Button enableButton;
    private final Button disableButton;

    public VehicleKey(VehicleKeyReceiverModule receiver, String encryptedPassword) {
        enableButton = new Button(new CommandEnable(receiver));
        disableButton = new Button(new CommandEnable(receiver));
        this.encryptedPassword = encryptedPassword;
    }
}
