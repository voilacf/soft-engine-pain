package s02bridge;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import s01components.control_units.ComponentUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThenBridge extends Stage<ThenBridge> {
    private static final int BATTERY_INITIAL_ENERGY = 250000;
    @ExpectedScenarioState
    public Object battery;

    public ThenBridge shouldHaveUsedEnergy(int energyCount) {
        int batteryCharge = (int) ComponentUtils.invokeMethod(battery, "getEnergy");
        assertEquals(BATTERY_INITIAL_ENERGY - energyCount, batteryCharge);
        return self();
    }
}
