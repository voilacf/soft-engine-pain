package s02adapter;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenAdapter extends Stage<GivenAdapter>{
    @ProvidedScenarioState
    public AmazonZooxBatteryCharger chargerZoox;
    @ProvidedScenarioState
    public AutoXBatteryCharger chargerAutoX;

    @ProvidedScenarioState
    public IChargable chargable;

    public GivenAdapter aZooxCharger() {
        AmazonZooxChargingAdapter adapter = new AmazonZooxChargingAdapter();
        chargerZoox = adapter;
        chargable = adapter;

        return self();
    }

    public GivenAdapter aAutoXAdapter() {
        AutoXChargingAdapter adapter = new AutoXChargingAdapter();
        chargerAutoX = adapter;
        chargable = adapter;
        return self();
    }
}
