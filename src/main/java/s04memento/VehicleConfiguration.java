package s04memento;

import s01components.application.ApplicationConfiguration;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class VehicleConfiguration {
    private boolean rejectDrunkenPassengers;
    private boolean stopByPoliceRequest;
    private boolean allowDriveByNight;
    private NaggingPassengersBehavior behaviorWithNaggingPassengers;
    private DriveMusic musicDuringDrive;

    public VehicleConfiguration() {
    }

    //Save the current configuration
    public VehicleConfigurationMemento save() {
        VehicleConfigurationMemento memento = new VehicleConfigurationMemento();
        memento.rejectDrunkenPassengers = this.rejectDrunkenPassengers;
        memento.stopByPoliceRequest = this.stopByPoliceRequest;
        memento.allowDriveByNight = this.allowDriveByNight;
        memento.behaviorWithNaggingPassengers = this.behaviorWithNaggingPassengers;
        memento.musicDuringDrive = this.musicDuringDrive;
        return memento;
    }

    //Restore the configuration from the memento
    public void restore(VehicleConfigurationMemento memento) {
        this.rejectDrunkenPassengers = memento.rejectDrunkenPassengers;
        this.stopByPoliceRequest = memento.stopByPoliceRequest;
        this.allowDriveByNight = memento.allowDriveByNight;
        this.behaviorWithNaggingPassengers = memento.behaviorWithNaggingPassengers;
        this.musicDuringDrive = memento.musicDuringDrive;
        System.out.println("Configuration restored");
    }

    //Print the current configuration
    public void print() {
        System.out.println("Current configuration:");
        System.out.println("    rejectDrunkenPassengers: " + rejectDrunkenPassengers);
        System.out.println("    stopByPoliceRequest: " + stopByPoliceRequest);
        System.out.println("    allowDriveByNight: " + allowDriveByNight);
        System.out.println("    behaviorWithNaggingPassengers: " + behaviorWithNaggingPassengers);
        System.out.println("    musicDuringDrive: " + musicDuringDrive);
    }

    //Change a parameter
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

    //Show the parameter change prompts in the console
    private void setParameterPrompt() {
        this.print();
        System.out.println("Possible keys: 0=rejectDrunkenPassengers, 1=stopByPoliceRequest, 2=allowDriveByNight, 3=behaviorWithNaggingPassengers, 4=musicDuringDrive");
        int key = 0;
        String keyString = "";
        do {
            System.out.print("Key: ");
            System.out.flush();
            try {
                key = new Scanner(System.in).nextInt();
            } catch (NoSuchElementException ignored) {
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
            } catch (NoSuchElementException ignored) {
            }
        } while (value < 0 || value > 1);
        this.setParameter(keyString, value);
    }

    //Enter the configuration mode
    public void enterConfigurationMode() {
        String configPath = "config.json";
        ApplicationConfiguration applicationConfiguration = ApplicationConfiguration.loadJSONConfig(configPath);
        this.restore(applicationConfiguration.getVehicleConfigurationMemento());

        System.out.println("Possible commands: print, set parameter, undo, exit");

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
                case "set parameter" -> setParameterPrompt();
                case "undo" -> this.restore(applicationConfiguration.getVehicleConfigurationMemento());
                case "exit" -> {
                    applicationConfiguration.setVehicleConfigurationMemento(this.save());
                    applicationConfiguration.saveJSONConfig(configPath);
                    System.exit(0);
                }
            }
        }
    }

    public boolean isRejectDrunkenPassengers() {
        return rejectDrunkenPassengers;
    }

    public boolean isStopByPoliceRequest() {
        return stopByPoliceRequest;
    }

    public boolean isAllowDriveByNight() {
        return allowDriveByNight;
    }

    public NaggingPassengersBehavior getBehaviorWithNaggingPassengers() {
        return behaviorWithNaggingPassengers;
    }

    public DriveMusic getMusicDuringDrive() {
        return musicDuringDrive;
    }
}
