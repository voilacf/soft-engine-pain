package s02builder;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import s03command.Door;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

public class ThenBuilder extends Stage<ThenBuilder> {
    @ExpectedScenarioState
    public AutonomousVehicle vehicle;

    public ThenBuilder hasAChassis() {
        assertNotNull(vehicle.getChassis());
        return self();
    }

    public ThenBuilder hasAEngine() {
        assertNotNull(vehicle.getEngine());
        return self();
    }

    public ThenBuilder hasBattery() {
        assertNotNull(vehicle.getBattery());
        return self();
    }

    public ThenBuilder hasHeadlights(int count) {
        assertEquals(count, vehicle.getHeadlights().length);
        for (Object o : vehicle.getHeadlights()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasBrakes(int count) {
        assertEquals(count, vehicle.getBrakes().length);
        for (Object o : vehicle.getBrakes()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasIndicators(int count) {
        assertEquals(count, vehicle.getIndicators().length);
        for (Object o : vehicle.getIndicators()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasDoors(int count) {
        assertEquals(count, vehicle.getDoors().length);
        for (Door o : vehicle.getDoors()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasSeatBenches(int count) {
        assertEquals(count, vehicle.getSeats().length);
        for (ISittable o : vehicle.getSeats()) {
            assertNotNull(o);
            assertTrue(o instanceof SeatBench);
        }
        return self();
    }

    public ThenBuilder hasSeats(int count) {
        assertEquals(count, vehicle.getSeats().length);
        for (ISittable o : vehicle.getSeats()) {
            assertNotNull(o);
            assertTrue(o instanceof Seat);
        }
        return self();
    }

    public ThenBuilder hasWheels(int count) {
        assertEquals(count, vehicle.getWheels().length);
        for (Object o : vehicle.getWheels()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasGps(int count) {
        assertEquals(count, vehicle.getGps().length);
        for (Object o : vehicle.getGps()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasCameras(int count) {
        assertEquals(count, vehicle.getCameras().length);
        for (Object o : vehicle.getCameras()) {
            assertNotNull(o);
        }
        return self();
    }

    public ThenBuilder hasLidars(int count) {
        assertEquals(count, vehicle.getLidars().length);
        for (Object o : vehicle.getLidars()) {
            assertNotNull(o);
        }
        return self();
    }
}
