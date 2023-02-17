package s04.memento;

public class VehicleConfigurationMemento {
    public boolean rejectDrunkenPassengers = true;
    public boolean stopByPoliceRequest = true;
    public boolean allowDriveByNight = true;

    public NaggingPassengersBehavior behaviorWithNaggingPassengers = NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE;

    public DriveMusic musicDuringDrive = DriveMusic.AC_DC;
}
