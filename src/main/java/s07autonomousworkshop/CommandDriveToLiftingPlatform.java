package s07autonomousworkshop;

import s02builder.AutonomousVehicle;
import s03command.ICommand;

public class CommandDriveToLiftingPlatform implements ICommand {
    private final AutonomousVehicle vehicle;
    private final LiftingPlatform liftingPlatform;

    public CommandDriveToLiftingPlatform(AutonomousVehicle vehicle, LiftingPlatform liftingPlatform) {
        this.vehicle = vehicle;
        this.liftingPlatform = liftingPlatform;
    }

    @Override
    public void execute() {
        vehicle.driveOntoLiftingPlatform(liftingPlatform);
    }
}
