package factories;

public enum Configuration {
    INSTANCE;

    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");


    public final String pathToBatteryJavaArchive = userDirectory + fileSeparator + "battery" + fileSeparator + "jar" + fileSeparator;
    public final String pathToBrakeJavaArchive = userDirectory + fileSeparator + "brake" +  fileSeparator + "jar" + fileSeparator;
    public final String pathToBrakeLightJavaArchive = userDirectory + fileSeparator + "brakelight" +  fileSeparator + "jar" + fileSeparator;
    public final String pathToCameraJavaArchive = userDirectory + fileSeparator + "camera" +  fileSeparator + "jar" + fileSeparator;
    public final String pathToElectricEngineJavaArchive = userDirectory + fileSeparator + "electric-engine" + fileSeparator + "jar" + fileSeparator;
    public final String pathToGPSJavaArchive = userDirectory + fileSeparator + "gps" + fileSeparator  + "jar" + fileSeparator;
    public final String pathToIndicatorJavaArchive = userDirectory + fileSeparator + "indicator" + fileSeparator + "jar" + fileSeparator;
    public final String pathToLedHeadlightJavaArchive = userDirectory + fileSeparator + "led-headlight" + fileSeparator + "jar" + fileSeparator;
    public final String pathToLidarJavaArchive = userDirectory + fileSeparator + "lidar" + fileSeparator + "jar" + fileSeparator;
}
