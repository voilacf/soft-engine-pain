package components;

import control_unit.VehicleControlUnit;

public class VehicleKeyReceiverModule {
    private final VehicleControlUnit controlUnit;

    public VehicleKeyReceiverModule(VehicleControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void enableVehicle(String encryptedPassword) {
        // TODO: check password
        controlUnit.startup();
    }

    public void disableVehicle(String encryptedPassword) {
        // TODO: check password
        controlUnit.shutdown();
    }
}
