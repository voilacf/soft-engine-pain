package s07autonomousworkshop;

import s02builder.AutonomousVehicle;

public class LiftingPlatform {
    private final LiftingPlatformSensor sensor = new LiftingPlatformSensor();
    private final WorkshopRoboter[] roboters = new WorkshopRoboter[2];
    private AutonomousVehicle vehicle;

    public LiftingPlatform() {
        for (int i = 0; i < roboters.length; i++) {
            roboters[i] = new WorkshopRoboter(i == 0);
        }
    }

    public void driveOnTo(AutonomousVehicle vehicle) {
        System.out.println("Vehicle " + vehicle + " drives onto a lifting platform");
        this.vehicle = vehicle;
        sensor.vehicleRegistered(vehicle);

        for (WorkshopRoboter roboter : roboters) {
            roboter.doMaintenance(vehicle);
        }

        System.out.println("Vehicle " + vehicle + " is done with maintenance and drives off a lifting platform");
    }

    public LiftingPlatformSensor getSensor() {
        return sensor;
    }

    public AutonomousVehicle getVehicle() {
        return vehicle;
    }
}
