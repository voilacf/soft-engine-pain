package s02builder;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.application.ApplicationConfiguration;
import s05servicecenter.ServiceCenter;

public class WhenBuilder extends Stage<WhenBuilder> {
    @ExpectedScenarioState
    public ApplicationConfiguration configuration;
    @ExpectedScenarioState
    public ServiceCenter serviceCenter;

    @ProvidedScenarioState
    public AutonomousVehicle vehicle;

    public WhenBuilder buildingAmazonZoox() {
        vehicle = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
        return self();
    }

    public WhenBuilder buildingAutoX() {
        vehicle = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);
        return self();
    }
}
