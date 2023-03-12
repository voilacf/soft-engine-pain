package s02bridge;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.control_units.ComponentUtils;
import static org.junit.jupiter.api.Assertions.*;

public class ThenBridge extends Stage<ThenBridge> {
    @ExpectedScenarioState
    public Object battery;
    private static final int BATTERY_INITIAL_ENERGY = 250000;

    public ThenBridge shouldHaveUsedEnergy(int energyCount) {
        int batteryCharge = (int) ComponentUtils.invokeMethod(battery, "getEnergy");
        assertEquals(BATTERY_INITIAL_ENERGY - energyCount, batteryCharge);
        return self();
    }
}
