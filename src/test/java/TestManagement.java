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
        batteryPort = Factory.buildBattery();
        brakePort = Factory.buildBrake();
        brakeLightPort = Factory.buildBrakeLight();
        //cameraPort = Factory.buildCamera();
        //enginePort = Factory.buildEngine();
        gpsPort = Factory.buildGPS();
        indicatorPort = Factory.buildIndicator();
        ledPort = Factory.buildLED();
        //lidarPort = Factory.buildLidar();
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
