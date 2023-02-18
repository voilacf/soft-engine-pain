public enum Configuration {
    INSTANCE;

    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");

    public final String pathToBatteryJavaArchive = userDirectory + fileSeparator + "battery" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToBrakeJavaArchive = userDirectory + fileSeparator + "brake" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToBrakeLightJavaArchive = userDirectory + fileSeparator + "brakelight" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToCameraJavaArchive = userDirectory + fileSeparator + "camera" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToElectricEngineJavaArchive = userDirectory + fileSeparator + "electric-engine" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToGPSJavaArchive = userDirectory + fileSeparator + "gps" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToIndicatorJavaArchive = userDirectory + fileSeparator + "indicator" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToLedHeadlightJavaArchive = userDirectory + fileSeparator + "led-headlight" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToLidarJavaArchive = userDirectory + fileSeparator + "lidar" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
}
