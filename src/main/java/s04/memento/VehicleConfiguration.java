package s04.memento;

public class VehicleConfiguration {
    private boolean rejectDrunkenPassengers = true;
    private boolean stopByPoliceRequest = true;
    private boolean allowDriveByNight = true;

    private NaggingPassengersBehavior behaviorWithNaggingPassengers = NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE;

    private DriveMusic musicDuringDrive = DriveMusic.AC_DC;


    //Todo
    public VehicleConfiguration() {

    }


    public VehicleConfigurationMemento save() {
        VehicleConfigurationMemento memento = new VehicleConfigurationMemento();
        memento.rejectDrunkenPassengers = this.rejectDrunkenPassengers;
        memento.stopByPoliceRequest = this.stopByPoliceRequest;
        memento.allowDriveByNight = this.allowDriveByNight;
        memento.behaviorWithNaggingPassengers = this.behaviorWithNaggingPassengers;
        memento.musicDuringDrive = this.musicDuringDrive;
        return memento;
    }

    public void restore(VehicleConfigurationMemento memento) {
        this.rejectDrunkenPassengers = memento.rejectDrunkenPassengers;
        this.stopByPoliceRequest = memento.stopByPoliceRequest;
        this.allowDriveByNight = memento.allowDriveByNight;
        this.behaviorWithNaggingPassengers = memento.behaviorWithNaggingPassengers;
        this.musicDuringDrive = memento.musicDuringDrive;
    }

    public void print() {
        System.out.println("VehicleConfiguration [rejectDrunkenPassengers=" + rejectDrunkenPassengers + ", stopByPoliceRequest="
                + stopByPoliceRequest + ", allowDriveByNight=" + allowDriveByNight + ", behaviorWithNaggingPassengers="
                + behaviorWithNaggingPassengers + ", musicDuringDrive=" + musicDuringDrive + "]");
    }

    //Todo
    //Stimmt das so?
    public void setParameter(String key, int value){
        switch (key) {
        case "rejectDrunkenPassengers":
            this.rejectDrunkenPassengers = value == 1;
            break;
        case "stopByPoliceRequest":
            this.stopByPoliceRequest = value == 1;
            break;
        case "allowDriveByNight":
            this.allowDriveByNight = value == 1;
            break;
        case "behaviorWithNaggingPassengers":
            this.behaviorWithNaggingPassengers = value == 1 ? NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE : NaggingPassengersBehavior.DO_NOTHING;
            break;
        case "musicDuringDrive":
            this.musicDuringDrive = value == 1 ? DriveMusic.AC_DC : DriveMusic.HELENE_FISCHER;
            break;
        default:
            break;
        }
    }

    //Todo
    public void enterConfigurationMode() {
        System.out.println("Entering configuration mode...");
    }
}
