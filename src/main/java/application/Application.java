package application;

import builder.AutonomousVehicle;
import components.Door;
import components.VehicleKey;
import components.VehicleKeyReceiverModule;
import control_unit.VehicleControlUnit;
import factories.AutonomousVehicleFactory;
import observer.UltraSonicSensor;
import service_center.ServiceCenter;

public class Application {
    public static void main(String[] args) {
        ServiceCenter serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        AutonomousVehicle zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
        AutonomousVehicle autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);

        testVehicle(zoox);
        testVehicle(autox);
    }

    private static void testVehicle(AutonomousVehicle vehicle) {
        VehicleControlUnit controlUnit = vehicle.getControlUnit();
        VehicleKey key = new VehicleKey(new VehicleKeyReceiverModule(controlUnit), controlUnit.getVehicle().getType());
        key.enableVehicle();

        controlUnit.startup();
        controlUnit.move(100, 5);
        controlUnit.leftTurn(100, 5);
        controlUnit.rightTurn(100, 5);
        controlUnit.stop();
        controlUnit.emergencyStop();

        for (Door door : vehicle.getDoors()) {
            door.getToggleButton().pressButton();
            door.getToggleButton().pressButton();
            door.getEmergencyButton().pressButton();
        }

        // TODO(1adri1) print VehicleConfiguration here


        for (UltraSonicSensor us : vehicle.getUltraSonics()) {
            us.distanceChanged(Math.round(Math.random() * 10) + 5);
        }

        key.disableVehicle();
    }
}
