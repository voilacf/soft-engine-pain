import factories.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestManagement {
    private Object batteryPort;
    private Object brakePort;
    private Object brakeLightPort;
    private Object cameraPort;
    private Object enginePort;
    private Object gpsPort;
    private Object indicatorPort;
    private Object ledPort;
    private Object lidarPort;

    @BeforeEach
    public void setup() {
        batteryPort = BatteryFactory.build();
        brakePort = BrakeFactory.build();
        brakeLightPort = BrakeLightFactory.build();
        cameraPort = CameraFactory.build();
        enginePort = BatteryFactory.build();
        gpsPort = GPSFactory.build();
        indicatorPort = IndicatorFactory.build();
        ledPort = LEDHeadLightFactroy.build();
        lidarPort = LidarFactory.build();
    }

    @Test
    @Order(1)
    public void version() {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
