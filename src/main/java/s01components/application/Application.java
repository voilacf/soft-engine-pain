package s01components.application;

import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;
import s03command.Door;
import s03command.VehicleKey;
import s03command.VehicleKeyReceiverModule;
import s03facade.VehicleControlUnit;
import s04memento.VehicleConfigurationMemento;
import s04observer.UltraSonicSensor;
import s05servicecenter.ServiceCenter;
import s07autonomousworkshop.AutonomousWorkshop;

public class Application {
    public static void main(String[] args) {
        String configPath;
        if (args.length >= 2 && args[0].equals("-config")) {
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
        testWorkshop(serviceCenter, configuration);
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

    private static void testWorkshop(ServiceCenter serviceCenter,ApplicationConfiguration configuration) {
        System.out.println("\n\n\nTesting workshop:\n");

        AutonomousWorkshop workshop = new AutonomousWorkshop();
        // 2x autox and 3x zoox
        for (int i = 0; i < 2; i++) {
            workshop.addVehicleToQueue(AutonomousVehicleFactory.buildAutoX(null, configuration));
        }
        for (int i = 0; i < 3; i++) {
            workshop.addVehicleToQueue(AutonomousVehicleFactory.buildAmazonZoox(null, configuration));
        }

        workshop.doAllVehicles();
    }
}
