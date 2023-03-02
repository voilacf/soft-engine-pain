package s03.facade;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import observer_S04.VehicleControlUnit;

public class WhenVehicleControlUnit extends Stage<WhenVehicleControlUnit> {
    @ExpectedScenarioState
    public VehicleControlUnit vehicleControlUnit;

    public WhenVehicleControlUnit startupIsCalled() {
        vehicleControlUnit.startup();
        return self();
    }

    public WhenVehicleControlUnit moveIsCalled(int deltaRPM, int seconds) {
        vehicleControlUnit.move(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit leftTurnIsCalled(int deltaRPM, int seconds) {
        vehicleControlUnit.leftTurn(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit right_turn_is_called(int deltaRPM, int seconds) {
        vehicleControlUnit.rightTurn(deltaRPM, seconds);
        return self();
    }

    public WhenVehicleControlUnit stopIsCalled() {
        vehicleControlUnit.stop();
        return self();
    }

    public WhenVehicleControlUnit emergencyStopIsCalled() {
        vehicleControlUnit.emergencyStop();
        return self();
    }

    public WhenVehicleControlUnit shutdownIsCalled() {
        vehicleControlUnit.shutdown();
        return self();
    }
}
