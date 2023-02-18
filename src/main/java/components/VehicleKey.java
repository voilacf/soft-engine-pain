package components;

import builder.VehicleType;
import door_button.Button;
import door_button.CommandEnable;

public class VehicleKey {
    // TODO: implement password check in receiver
    private final VehicleKeyReceiverModule receiver;
    private final String encryptedPassword;
    private final Button enableButton;
    private final Button disableButton;

    public VehicleKey(VehicleKeyReceiverModule receiver, VehicleType vehicleType) {
        this.receiver = receiver;
        enableButton = new Button(new CommandEnable(this));
        disableButton = new Button(new CommandEnable(this));

        if (vehicleType == VehicleType.AUTOX) {
            this.encryptedPassword = VehicleKeyAESEncryption.encrypt(VehicleKeyAESEncryption.autoXPassword);
        } else {

            this.encryptedPassword = VehicleKeyAESEncryption.encrypt(VehicleKeyAESEncryption.zooxPassword);
        }
    }

    public void enableVehicle() {
        receiver.enableVehicle(encryptedPassword);
    }

    public void disableVehicle() {
        receiver.disableVehicle(encryptedPassword);
    }
}
