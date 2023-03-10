package s07autonomousworkshop;

import s02builder.AutonomousVehicle;
import s02builder.VehicleType;

import java.util.ArrayDeque;
import java.util.Queue;

public class AutonomousWorkshop implements ILiftingPlatformSensorListener {
    private final LiftingPlatform liftingPlatform = new LiftingPlatform();

    private final Queue<AutonomousVehicle> zooxQueue = new ArrayDeque<>();

    private final Queue<AutonomousVehicle> autoXQueue = new ArrayDeque<>();

    public AutonomousWorkshop() {
        liftingPlatform.getSensor().addListener(this);
    }

    public void vehicleRegistered(AutonomousVehicle vehicle) {
        System.out.println("Vehicle " + vehicle + " drove successfully onto a lifting platform");
    }

    public void addVehicleToQueue(AutonomousVehicle vehicle){
        if(vehicle.getType() == VehicleType.AUTOX) {
            autoXQueue.add(vehicle);
        } else {
            zooxQueue.add(vehicle);
        }
    }

    public void doNextVehicle() {
        if(!hasNextVehicle()) {
            return;
        }

        // Get vehicle, zoox has priority
        AutonomousVehicle vehicle = !zooxQueue.isEmpty() ? zooxQueue.poll() : autoXQueue.poll();

        // Initiate maintenance/repairs
        new CommandDriveToLiftingPlatform(vehicle, liftingPlatform).execute();
    }

    public boolean hasNextVehicle() {
        return !zooxQueue.isEmpty() || !autoXQueue.isEmpty();
    }

    public void doAllVehicles() {
        while (hasNextVehicle()) {
            doNextVehicle();
        }
    }
}
