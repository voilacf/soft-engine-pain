package components;

import door_button.Button;
import door_button.CommandEnable;

public class VehicleKey {
    // TODO: implement password check in receiver
    private final VehicleKeyReceiverModule receiver;
    private final String encryptedPassword;
    private final Button enableButton;
    private final Button disableButton;

    public VehicleKey(VehicleKeyReceiverModule receiver, String encryptedPassword) {
        this.receiver = receiver;
        enableButton = new Button(new CommandEnable(this));
        disableButton = new Button(new CommandEnable(this));
        this.encryptedPassword = encryptedPassword;
    }

    public void enableVehicle() {
        receiver.enableVehicle(encryptedPassword);
    }

    public void disableVehicle() {
        receiver.disableVehicle(encryptedPassword);
    }
}
