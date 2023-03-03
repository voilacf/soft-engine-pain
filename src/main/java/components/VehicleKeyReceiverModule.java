package components;

import builder.VehicleType;
import observer_S04.VehicleControlUnit;

public class VehicleKeyReceiverModule {
    private final VehicleControlUnit controlUnit;

    public VehicleKeyReceiverModule(VehicleControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    private void checkPassword(String encryptedPassword) {
        VehicleType vehicleType = controlUnit.getVehicle().getType();
        String password = vehicleType == VehicleType.AUTOX ? VehicleKeyAESEncryption.autoXPassword : VehicleKeyAESEncryption.zooxPassword;
        String expectedPassword = VehicleKeyAESEncryption.encrypt(password);

        if (!encryptedPassword.equals(expectedPassword)) {
            throw new RuntimeException("Invalid vehicle key password");
        }
    }

    public void enableVehicle(String encryptedPassword) {
        checkPassword(encryptedPassword);
        controlUnit.startup();
    }

    public void disableVehicle(String encryptedPassword) {
        checkPassword(encryptedPassword);
        controlUnit.shutdown();
    }
}
