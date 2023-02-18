package memento;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VehicleConfiguration {
    private boolean rejectDrunkenPassengers = true;
    private boolean stopByPoliceRequest = true;
    private boolean allowDriveByNight = true;

    private NaggingPassengersBehavior behaviorWithNaggingPassengers = NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE;

    private DriveMusic musicDuringDrive = DriveMusic.AC_DC;

    //Todo Hauptconfig laden
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

        System.out.println("Configuration restored");
    }

    public void print() {
        System.out.println("Current configuration:");
        System.out.println("    rejectDrunkenPassengers: " + rejectDrunkenPassengers);
        System.out.println("    stopByPoliceRequest: " + stopByPoliceRequest);
        System.out.println("    allowDriveByNight: " + allowDriveByNight);
        System.out.println("    behaviorWithNaggingPassengers: " + behaviorWithNaggingPassengers);
        System.out.println("    musicDuringDrive: " + musicDuringDrive);
    }

    public void setParameter(String key, int value) {
        if (value != 0 && value != 1) {
            System.out.println("Invalid value");
            enterConfigurationMode();
        }

        switch (key) {
            case "rejectDrunkenPassengers" -> this.rejectDrunkenPassengers = value == 1;
            case "stopByPoliceRequest" -> this.stopByPoliceRequest = value == 1;
            case "allowDriveByNight" -> this.allowDriveByNight = value == 1;
            case "behaviorWithNaggingPassengers" ->
                    this.behaviorWithNaggingPassengers = value == 1 ? NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE : NaggingPassengersBehavior.DO_NOTHING;
            case "musicDuringDrive" ->
                    this.musicDuringDrive = value == 1 ? DriveMusic.AC_DC : DriveMusic.HELENE_FISCHER;
            default -> {
            }
        }
    }

    public void setParameterPrompt() {
        this.print();
        System.out.println("Possible keys: 0=rejectDrunkenPassengers, 1=stopByPoliceRequest, 2=allowDriveByNight, 3=behaviorWithNaggingPassengers, 4=musicDuringDrive");
        int key = 0;
        String keyString = "";
        do {
            System.out.print("Key: ");
            System.out.flush();
            try {
                key = new Scanner(System.in).nextInt();
            } catch (NoSuchElementException e) {
                System.exit(0);
                break;
            }
        } while (key < 0 || key > 4);
        switch (key) {
            case 0 -> {
                keyString = "rejectDrunkenPassengers";
                System.out.println("Possible values: 0=false, 1=true");
            }
            case 1 -> {
                keyString = "stopByPoliceRequest";
                System.out.println("Possible values: 0=false, 1=true");
            }
            case 2 -> {
                keyString = "allowDriveByNight";
                System.out.println("Possible values: 0=false, 1=true");
            }
            case 3 -> {
                keyString = "behaviorWithNaggingPassengers";
                System.out.println("Possible values: 0=DO_NOTHING, 1:STOP_AND_WAIT_FOR_EXCUSE");
            }
            case 4 -> {
                keyString = "musicDuringDrive";
                System.out.println("Possible values: 0=HELENE_FISCHER, 1=AC_DC");
            }
            default -> {
            }
        }
        int value = 0;
        do {
            System.out.print("Value: ");
            System.out.flush();
            try {
                value = new Scanner(System.in).nextInt();
            } catch (NoSuchElementException e) {
                System.exit(0);
                break;
            }
        } while (value < 0 || value > 1);
        this.setParameter(keyString, value);
    }


    //Todo In Hauptconfig bei exit schreiben
    public void enterConfigurationMode() {
        VehicleConfigurationMemento memento = this.save();
        System.out.println("Possible commands: print, set parameter, restore, exit");

        while (true) {
            System.out.print("-> ");
            System.out.flush();
            String input;

            try {
                input = new Scanner(System.in).nextLine();
            } catch (NoSuchElementException e) {
                System.exit(0);
                break;
            }

            switch (input.trim()) {
                case "print" -> this.print();

                case "set parameter" -> {
                    setParameterPrompt();
                }

                case "undo" -> this.restore(memento);

                case "exit" -> {
                    memento = this.save();
                    System.exit(0);
                }
            }
        }
    }
}
