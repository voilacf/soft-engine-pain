package s03.facade;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import control_unit.VehicleControlUnit;

public class WhenVehicleControlUnit extends Stage<WhenVehicleControlUnit> {
    @ExpectedScenarioState
    public VehicleControlUnit vehicleControlUnit;

    public WhenVehicleControlUnit startup_is_called() {
        vehicleControlUnit.startup();
        return self();
    }

    public WhenVehicleControlUnit move_is_called(int deltaRPM, int seconds) {
        vehicleControlUnit.move(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit left_turn_is_called(int deltaRPM, int seconds) {
        vehicleControlUnit.leftTurn(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit right_turn_is_called(int deltaRPM, int seconds) {
        vehicleControlUnit.rightTurn(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit stop_is_called() {
        vehicleControlUnit.stop();
        return self();
    }

    public WhenVehicleControlUnit emergency_stop_is_called() {
        vehicleControlUnit.emergencyStop();
        return self();
    }

    public WhenVehicleControlUnit shutdown_is_called() {
        vehicleControlUnit.shutdown();
        return self();
    }
}
