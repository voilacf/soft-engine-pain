package s03.command;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s02builder.AutonomousVehicle;
import s04state.DoorStateClosed;
import s04state.DoorStateOpened;
import s05servicecenter.ServiceCenter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class ThenCommand extends Stage<ThenCommand> {
    @ProvidedScenarioState
    public AutonomousVehicle vehicle;

    @ProvidedScenarioState
    public ServiceCenter serviceCenter;

    public ThenCommand theDoorIsClosed() {
        assertTrue(vehicle.getDoors()[0].getState() instanceof DoorStateClosed);
        return self();
    }

    public ThenCommand theDoorIsOpen() {
        assertTrue(vehicle.getDoors()[0].getState() instanceof DoorStateOpened);
        return self();
    }

    public ThenCommand serviceCenterGotNotifiedAboutEmergency() {
        verify(serviceCenter).handleEmergency();
        return self();
    }

    public ThenCommand theVehicleIsStarted() {
        assertTrue(vehicle.getControlUnit().isStarted());
        return self();
    }

    public ThenCommand theVehicleIsStopped() {
        assertFalse(vehicle.getControlUnit().isStarted());
        return self();
    }
}
