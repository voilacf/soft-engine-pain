package application;

import builder.AutonomousVehicle;
import components.VehicleKey;
import components.VehicleKeyReceiverModule;
import control_unit.VehicleControlUnit;
import factories.AutonomousVehicleFactory;
import service_center.ServiceCenter;

public class Application {
    public static void main(String[] args) {
        ServiceCenter serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        AutonomousVehicle zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
        AutonomousVehicle autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);

        testVehicle(zoox.getControlUnit());
        testVehicle(autox.getControlUnit());
    }

    private static void testVehicle(VehicleControlUnit controlUnit) {
        VehicleKey key = new VehicleKey(new VehicleKeyReceiverModule(controlUnit), controlUnit.getVehicle().getType());
        key.enableVehicle();

        controlUnit.startup();
        controlUnit.move(100, 5);
        controlUnit.leftTurn(100, 5);
        controlUnit.rightTurn(100, 5);
        controlUnit.stop();
        controlUnit.emergencyStop();

        key.disableVehicle();
    }
}
