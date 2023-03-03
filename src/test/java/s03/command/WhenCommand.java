package s03.command;

import builder.AutonomousVehicle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import components.VehicleKey;

public class WhenCommand extends Stage<WhenCommand> {
    @ProvidedScenarioState
    public AutonomousVehicle vehicle;

    @ProvidedScenarioState
    public VehicleKey key;

    public WhenCommand theDoorToggleDoorButtonIsPressed() {
        vehicle.getDoors()[0].getToggleButton().pressButton();
        return self();
    }

    public WhenCommand theDoorEmergencyButtonIsPressed() {
        vehicle.getDoors()[0].getEmergencyButton().pressButton();
        return self();
    }

    public WhenCommand pressingTheKeyEnableButton() {
        key.enableVehicle();
        return self();
    }

    public WhenCommand pressingTheKeyDisableButton() {
        key.disableVehicle();
        return self();
    }
}