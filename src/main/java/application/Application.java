package application;

import builder.AutonomousVehicle;
import components.VehicleKey;
import components.VehicleKeyReceiverModule;
import factories.AutonomousVehicleFactory;
import memento_S04.VehicleConfigurationMemento;
import observer_S04.Door;
import observer_S04.UltraSonicSensor;
import observer_S04.VehicleControlUnit;
import service_center.ServiceCenter;

public class Application {
    public static void main(String[] args) {
        String configPath;
        if(args.length >= 2 && args[0].equals("-config")) {
            configPath = args[1];
        } else {
            System.out.println("Using default configuration file: config.json");
            configPath = "config.json";
        }

        ServiceCenter serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = ApplicationConfiguration.loadJSONConfig(configPath);

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

        VehicleConfigurationMemento config = ApplicationConfiguration.loadJSONConfig("config.json").getVehicleConfigurationMemento();
        System.out.println("Current configuration:");
        System.out.println("    rejectDrunkenPassengers: " + config.rejectDrunkenPassengers);
        System.out.println("    stopByPoliceRequest: " + config.stopByPoliceRequest);
        System.out.println("    allowDriveByNight: " + config.allowDriveByNight);
        System.out.println("    behaviorWithNaggingPassengers: " + config.behaviorWithNaggingPassengers);
        System.out.println("    musicDuringDrive: " + config.musicDuringDrive);

        for (UltraSonicSensor us : vehicle.getUltraSonics()) {
            us.distanceChanged(Math.round(Math.random() * 10) + 5);
        }

        key.disableVehicle();
    }
}
