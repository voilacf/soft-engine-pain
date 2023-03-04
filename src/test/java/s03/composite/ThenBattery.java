package s03.composite;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import s01components.control_units.ComponentUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ThenBattery extends Stage<ThenBattery> {
    @ExpectedScenarioState
    public Object batteryUnit;

    public ThenBattery theBatteryHasCharge(int count) {
        Integer charge = (Integer) ComponentUtils.invokeMethod(batteryUnit, "getEnergy");
        assertNotNull(charge);
        assertEquals(count, charge.intValue());

        return self();
    }

    public ThenBattery theBatteryHasSubunits(int count) {
        List<Object> subUnits = (List<Object>) ComponentUtils.invokeMethod(batteryUnit, "getSubUnits");
        assertNotNull(subUnits);
        assertEquals(count, subUnits.size());

        return self();
    }
}
