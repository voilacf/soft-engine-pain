package application;

import memento.DriveMusic;
import memento.NaggingPassengersBehavior;
import memento.VehicleConfigurationMemento;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ApplicationConfiguration {
    private static String pathToConfigFile = "config.json";
    // TODO: load engine, camera and lidar from config file.
    private EngineComponentType engine;
    private CameraComponentType camera;
    private LidarComponentType lidar;
    private VehicleConfigurationMemento vehicleConfigurationMemento = new VehicleConfigurationMemento();

    public ApplicationConfiguration() {
    }

    public ApplicationConfiguration(JSONObject jsonObject) {
        vehicleConfigurationMemento.rejectDrunkenPassengers = jsonObject.getBoolean("rejectDrunkenPassengers");
        vehicleConfigurationMemento.stopByPoliceRequest = jsonObject.getBoolean("stopByPoliceRequest");
        vehicleConfigurationMemento.allowDriveByNight = jsonObject.getBoolean("allowDriveByNight");
        vehicleConfigurationMemento.behaviorWithNaggingPassengers = NaggingPassengersBehavior.valueOf(jsonObject.getString("behaviorWithNaggingPassengers"));
        vehicleConfigurationMemento.musicDuringDrive = DriveMusic.valueOf(jsonObject.getString("musicDuringDrive"));
    }

   /* public ApplicationConfiguration loadFromjsonConfig() {
        return this;
    }
    */


    //For Config application.Application
    public static ApplicationConfiguration loadJSONConfig(String pathToConfigFile) {
        if (!Objects.equals(pathToConfigFile, "")) {
            ApplicationConfiguration.pathToConfigFile = pathToConfigFile;
        }
        File file = new File(pathToConfigFile);
        JSONObject jsonObject = new JSONObject();
        if (file.exists()) {
            System.out.println("Config file found!");
            try {
                // Load the file as a string
                String jsonString = FileUtils.readFileToString(file, "UTF-8");
                System.out.println("Config file loaded!");
                // Convert the string to a JSON object

                jsonObject = new JSONObject(jsonString);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Config file not found!");
            System.out.println("Creating new config file...");
            jsonObject.put("rejectDrunkenPassengers", true);
            jsonObject.put("stopByPoliceRequest", true);
            jsonObject.put("allowDriveByNight", true);
            jsonObject.put("behaviorWithNaggingPassengers", "STOP_AND_WAIT_FOR_EXCUSE");
            jsonObject.put("musicDuringDrive", "AC_DC");

        }
        return new ApplicationConfiguration(jsonObject);
    }

    //For Config application.Application
    public void saveJSONConfig() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rejectDrunkenPassengers", vehicleConfigurationMemento.rejectDrunkenPassengers);
        jsonObject.put("stopByPoliceRequest", vehicleConfigurationMemento.stopByPoliceRequest);
        jsonObject.put("allowDriveByNight", vehicleConfigurationMemento.allowDriveByNight);
        jsonObject.put("behaviorWithNaggingPassengers", vehicleConfigurationMemento.behaviorWithNaggingPassengers.toString());
        jsonObject.put("musicDuringDrive", vehicleConfigurationMemento.musicDuringDrive.toString());

        try {
            // Write the JSON object to a file
            FileUtils.writeStringToFile(new File(pathToConfigFile), jsonObject.toString(4), "UTF-8");
            System.out.println("Config file saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VehicleConfigurationMemento getVehicleConfigurationMemento() {
        return vehicleConfigurationMemento;
    }

    public void setVehicleConfigurationMemento(VehicleConfigurationMemento vehicleConfigurationMemento) {
        this.vehicleConfigurationMemento = vehicleConfigurationMemento;
    }

    public EngineComponentType getEngine() {
        return engine;
    }

    public CameraComponentType getCamera() {
        return camera;
    }

    public LidarComponentType getLidar() {
        return lidar;
    }

    public String getPathToConfigFile() {
        return pathToConfigFile;
    }

    public void setPathToConfigFile(String pathToConfigFile) {
        ApplicationConfiguration.pathToConfigFile = pathToConfigFile;
    }
}
