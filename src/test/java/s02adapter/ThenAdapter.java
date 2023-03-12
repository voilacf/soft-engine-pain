package s02adapter;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.junit.jupiter.api.Assertions.*;

public class ThenAdapter extends Stage<ThenAdapter>{
    @ExpectedScenarioState
    public AmazonZooxBatteryCharger chargerZoox;
    @ExpectedScenarioState
    public AutoXBatteryCharger chargerAutoX;

    public ThenAdapter zooxChargerWasPluggedIn() {
        assertTrue(chargerZoox.isPluggedIn());
        return self();
    }

    public ThenAdapter autoXChargerWasPluggedIn() {
        assertTrue(chargerAutoX.isPluggedIn());
        return self();
    }
}
