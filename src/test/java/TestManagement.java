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
        batteryPort = ComponentFactory.buildBattery();
        brakePort = ComponentFactory.buildBrake();
        brakeLightPort = ComponentFactory.buildBrakeLight();
        //cameraPort = Factory.buildCamera();
        //enginePort = Factory.buildEngine();
        gpsPort = ComponentFactory.buildGPS();
        indicatorPort = ComponentFactory.buildIndicator();
        ledPort = ComponentFactory.buildLED();
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
