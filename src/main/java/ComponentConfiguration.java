public class ComponentConfiguration {
    private EngineComponentType engine;
    private CameraComponentType camera;
    private LidarComponentType lidar;

    public ComponentConfiguration() {

    }

    public ComponentConfiguration loadFromjsonConfig() {
        return this;
    }
}
