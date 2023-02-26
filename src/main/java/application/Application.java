package application;

import builder.AutonomousVehicle;
import factories.AutonomousVehicleFactory;
import service_center.ServiceCenter;

public class Application {
    public static void main(String[] args) {
        ServiceCenter serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        AutonomousVehicle zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
        AutonomousVehicle autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);
    }
}
