package s01components.application;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import s04memento.DriveMusic;
import s04memento.NaggingPassengersBehavior;
import s04memento.VehicleConfigurationMemento;

import java.io.File;
import java.io.IOException;

public class ApplicationConfiguration {
    private static ApplicationConfiguration instance;
    private EngineComponentType engine;
    private CameraComponentType camera;
    private LidarComponentType lidar;
    private VehicleConfigurationMemento vehicleConfigurationMemento = new VehicleConfigurationMemento();

    public ApplicationConfiguration() {
        engine = EngineComponentType.ENGINE_X;
        camera = CameraComponentType.CAMERA_V1;
        lidar = LidarComponentType.LIDAR_NG;
    }

    public ApplicationConfiguration(JSONObject jsonObject) {
        engine = EngineComponentType.valueOf(jsonObject.getString("engineType"));
        camera = CameraComponentType.valueOf(jsonObject.getString("cameraType"));
        lidar = LidarComponentType.valueOf(jsonObject.getString("lidarType"));

        vehicleConfigurationMemento.rejectDrunkenPassengers = jsonObject.getBoolean("rejectDrunkenPassengers");
        vehicleConfigurationMemento.stopByPoliceRequest = jsonObject.getBoolean("stopByPoliceRequest");
        vehicleConfigurationMemento.allowDriveByNight = jsonObject.getBoolean("allowDriveByNight");
        vehicleConfigurationMemento.behaviorWithNaggingPassengers = NaggingPassengersBehavior.valueOf(jsonObject.getString("behaviorWithNaggingPassengers"));
        vehicleConfigurationMemento.musicDuringDrive = DriveMusic.valueOf(jsonObject.getString("musicDuringDrive"));
    }

    //For Config application.Application
    public static ApplicationConfiguration loadJSONConfig(String pathToConfigFile) {
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
            // Config memento
            jsonObject.put("rejectDrunkenPassengers", true);
            jsonObject.put("stopByPoliceRequest", true);
            jsonObject.put("allowDriveByNight", true);
            jsonObject.put("behaviorWithNaggingPassengers", "STOP_AND_WAIT_FOR_EXCUSE");
            jsonObject.put("musicDuringDrive", "AC_DC");


            jsonObject.put("engineType", "ENGINE_X");
            jsonObject.put("cameraType", "CAMERA_V1");
            jsonObject.put("lidarType", "LIDAR_NG");
        }
        return instance = new ApplicationConfiguration(jsonObject);
    }

    public static ApplicationConfiguration getInstance() {
        return instance;
    }

    //For Config application.Application
    public void saveJSONConfig(String pathToConfigFile) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rejectDrunkenPassengers", vehicleConfigurationMemento.rejectDrunkenPassengers);
        jsonObject.put("stopByPoliceRequest", vehicleConfigurationMemento.stopByPoliceRequest);
        jsonObject.put("allowDriveByNight", vehicleConfigurationMemento.allowDriveByNight);
        jsonObject.put("behaviorWithNaggingPassengers", vehicleConfigurationMemento.behaviorWithNaggingPassengers.toString());
        jsonObject.put("musicDuringDrive", vehicleConfigurationMemento.musicDuringDrive.toString());

        jsonObject.put("engineType", engine.toString());
        jsonObject.put("cameraType", camera.toString());
        jsonObject.put("lidarType", lidar.toString());

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
}
