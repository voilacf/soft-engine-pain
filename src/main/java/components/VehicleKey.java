package components;

import builder.VehicleType;
import door_button.Button;
import door_button.CommandDisable;
import door_button.CommandEnable;

public class VehicleKey {
    private final Button enableButton;
    private final Button disableButton;

    public VehicleKey(VehicleKeyReceiverModule receiver, VehicleType vehicleType) {
        String encryptedPassword;
        if (vehicleType == VehicleType.AUTOX) {
            encryptedPassword = VehicleKeyAESEncryption.encrypt(VehicleKeyAESEncryption.autoXPassword);
        } else {
            encryptedPassword = VehicleKeyAESEncryption.encrypt(VehicleKeyAESEncryption.zooxPassword);
        }

        enableButton = new Button(new CommandEnable(receiver, encryptedPassword));
        disableButton = new Button(new CommandDisable(receiver, encryptedPassword));
    }

    public void enableVehicle() {
        enableButton.pressButton();
    }

    public void disableVehicle() {
        disableButton.pressButton();
    }
}
