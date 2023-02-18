package door_button;

import control_unit.VehicleControlUnit;

public class VehicleKeyReceiverModule {
    private final VehicleControlUnit controlUnit;

    public VehicleKeyReceiverModule(VehicleControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void enableVehicle() {
        controlUnit.startup();
    }

    public void disableVehicle() {
        controlUnit.shutdown();
    }
}
