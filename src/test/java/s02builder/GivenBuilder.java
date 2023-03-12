package s02builder;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.application.ApplicationConfiguration;
import s04memento.VehicleConfiguration;
import s05servicecenter.ServiceCenter;

public class GivenBuilder extends Stage<GivenBuilder> {
    @ProvidedScenarioState
    public ApplicationConfiguration vehicleConfiguration;
    @ProvidedScenarioState
    public ServiceCenter serviceCenter;

    public GivenBuilder aConfigurationAndServiceCenter() {
        vehicleConfiguration = new ApplicationConfiguration();
        serviceCenter = new ServiceCenter();
        return self();
    }
}
