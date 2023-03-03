package s03.composite;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import control_unit.ComponentUtils;

public class WhenBattery extends Stage<WhenBattery> {
    @ExpectedScenarioState
    public Object batteryUnit;

    public WhenBattery useEnergy(int energyCount) {
        ComponentUtils.invokeMethod(batteryUnit, "useEnergy", new Class[]{int.class}, energyCount);

        return self();
    }

    public WhenBattery chargeBattery(int batteryCapacity) {
        ComponentUtils.invokeMethod(batteryUnit, "storeEnergy", new Class[]{int.class}, batteryCapacity);

        return self();
    }
}
