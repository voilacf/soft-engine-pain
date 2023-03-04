package s03.composite;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.control_units.ComponentUtils;
import s01components.ComponentFactory;

import java.util.List;

public class GivenBattery extends Stage<GivenBattery> {
    @ProvidedScenarioState
    public Object batteryUnit;

    public GivenBattery aBattery() {
        batteryUnit = ComponentFactory.buildBattery();
        return self();
    }

    public GivenBattery aMainCell() {
        aBattery();
        batteryUnit = getSubUnit(batteryUnit);

        return self();
    }

    public GivenBattery aSubCell() {
        aMainCell();
        batteryUnit = getSubUnit(batteryUnit);

        return self();
    }

    public GivenBattery aSingleBatteryCell() {
        aSubCell();
        batteryUnit = getSubUnit(batteryUnit);

        return self();
    }

    private Object getSubUnit(Object batteryUnit) {
        List<Object> subUnits = (List<Object>) ComponentUtils.invokeMethod(batteryUnit, "getSubUnits");
        return subUnits.get(0);
    }
}
