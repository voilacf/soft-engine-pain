package components;

import builder.VehicleType;
import door_button.CommandDisable;
import door_button.CommandEnable;
import observer_S04.Button;

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
        System.out.println("Enable key on vehicle key was pressed.");
        enableButton.pressButton();
    }

    public void disableVehicle() {
        System.out.println("Disable key on vehicle key was pressed.");
        disableButton.pressButton();
    }
}
