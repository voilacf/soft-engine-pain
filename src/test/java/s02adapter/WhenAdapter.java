package s02adapter;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class WhenAdapter extends Stage<WhenAdapter> {
    @ExpectedScenarioState
    public IChargable chargeable;

    public WhenAdapter charging() {
        chargeable.plugIn2Pin();
        return self();
    }
}
