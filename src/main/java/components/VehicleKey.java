package components;

import door_button.Button;
import door_button.CommandEnable;
import door_button.VehicleKeyReceiverModule;

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
