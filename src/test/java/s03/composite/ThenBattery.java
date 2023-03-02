package s03.composite;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import control_unit.ComponentUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
