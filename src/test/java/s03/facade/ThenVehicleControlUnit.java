package s03.facade;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import control_unit.VehicleControlUnit;
import testutils.GivenAutonomousVehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThenVehicleControlUnit extends Stage<ThenVehicleControlUnit> {
    @ExpectedScenarioState
    public VehicleControlUnit vehicleControlUnit;

    @ExpectedScenarioState
    public GivenAutonomousVehicle.ControlBusSubscriber controlBusSubscriber;

    /**
     * Ensures that the passed classes were seen on the control bus in the order they were passed.
     * Also ensures that the number of events seen on the control bus is equal to the number of event classes passed.
     */
    public ThenVehicleControlUnit control_bus_has_received_events(Class<?>[] eventClasses) {
        assertEquals(eventClasses.length, controlBusSubscriber.getReceivedEvents().size());

        for (int i = 0; i < eventClasses.length; i++) {
            Class<?> receivedEventClass = controlBusSubscriber.getReceivedEvents().get(i).getClass();
            assertEquals(eventClasses[i], receivedEventClass);
        }

        return self();
    }
}
