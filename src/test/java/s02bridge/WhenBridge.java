package s02bridge;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.control_units.ComponentUtils;

public class WhenBridge extends Stage<WhenBridge>{
    @ExpectedScenarioState
    Object engine;

    public WhenBridge increasingRpm(int deltaRPM, int seconds) {
        ComponentUtils.invokeMethod(engine, "increaseRPM", new Class[] {int.class, int.class}, deltaRPM, seconds);
        return self();
    }
}
