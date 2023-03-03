package s01;

import application.CameraComponentType;
import application.EngineComponentType;
import application.LidarComponentType;
import factories.ComponentFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestManagement {
    private Object batteryPort;
    private Object brakePort;
    private Object brakeLightPort;
    private Object cameraV1Port;
    private Object cameraV2Port;
    private Object engineNGPort;
    private Object engineXPort;
    private Object gpsPort;
    private Object indicatorPort;
    private Object ledPort;
    private Object lidarNGPort;
    private Object lidarXGPort;

    @BeforeEach
    public void setup() {
        batteryPort = ComponentFactory.buildBattery();
        brakePort = ComponentFactory.buildBrake();
        brakeLightPort = ComponentFactory.buildBrakeLight();
        cameraV1Port = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V1);
        cameraV2Port = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V2);
        engineNGPort = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        engineXPort = ComponentFactory.buildEngine(EngineComponentType.ENGINE_X);
        gpsPort = ComponentFactory.buildGPS();
        indicatorPort = ComponentFactory.buildIndicator();
        ledPort = ComponentFactory.buildLED();
        lidarNGPort = ComponentFactory.buildLidar(LidarComponentType.LIDAR_NG);
        lidarXGPort = ComponentFactory.buildLidar(LidarComponentType.LIDAR_XG);

    }

    @Test
    @Order(1)
    public void version() {
        try {
            assertNotNull(batteryPort);
            assertNotNull(brakePort);
            assertNotNull(brakeLightPort);
            assertNotNull(cameraV1Port);
            assertNotNull(cameraV2Port);
            assertNotNull(engineNGPort);
            assertNotNull(engineXPort);
            assertNotNull(gpsPort);
            assertNotNull(indicatorPort);
            assertNotNull(ledPort);
            assertNotNull(lidarNGPort);
            assertNotNull(lidarXGPort);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
