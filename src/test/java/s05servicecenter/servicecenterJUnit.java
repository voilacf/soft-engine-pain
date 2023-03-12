package s05servicecenter;

import org.junit.jupiter.api.*;
import s01components.application.ApplicationConfiguration;
import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class servicecenterJUnit {
    private AutonomousVehicle autox;
    private AutonomousVehicle zoox;
   private ServiceCenter serviceCenter;


    @BeforeEach
    public void setup() {
        this.serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        this.autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);
        this.zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
    }

    @Test
    @Order(1)
    public void emergencyCallFromAutoX() {
        assertTrue(serviceCenter.handleSpecificEmergency(EmployeeResponsibility.EMERGENCY, VehicleDivision.AUTO_X));
    }

    @Test
    @Order(2)
    public void emergencyCallFromZoox() {
        assertTrue(serviceCenter.handleSpecificEmergency(EmployeeResponsibility.EMERGENCY, VehicleDivision.ZOOX));
    }

    @Test
    @Order(3)
    public void maintananceCallFromAutoX() {
        assertTrue(serviceCenter.handleSpecificEmergency(EmployeeResponsibility.MAINTANCE, VehicleDivision.AUTO_X));
    }

    @Test
    @Order(4)
    public void maintananceCallFromZoox() {
        assertTrue(serviceCenter.handleSpecificEmergency(EmployeeResponsibility.MAINTANCE, VehicleDivision.ZOOX));
    }

    @Test
    @Order(5)
    public void noServiceEmployeeAvailable() {
        serviceCenter.handleSpecificEmergency(EmployeeResponsibility.MAINTANCE, VehicleDivision.ZOOX);
        serviceCenter.handleSpecificEmergency(EmployeeResponsibility.MAINTANCE, VehicleDivision.ZOOX);

        Assertions.assertFalse(serviceCenter.handleSpecificEmergency(EmployeeResponsibility.MAINTANCE, VehicleDivision.ZOOX));
    }


    @Test
    @Order(6)
    public void authenticatenWorks() {
        GateAuthenicator gate = new GateAuthenicator();
        ServiceEmployee employee = new ServiceEmployee(EmployeeResponsibility.MAINTANCE);
       assertTrue(gate.authenticateEmployee(employee, employee.employeeMagnetCard));
    }

    @Test
    @Order(7)
    public void checkIfAuthenticationIsSecure() {
        //Check if authetication returns false if the wrong card is used
        GateAuthenicator gate = new GateAuthenicator();
        ServiceEmployee employee1 = new ServiceEmployee(EmployeeResponsibility.MAINTANCE);
        ServiceEmployee employee2 = new ServiceEmployee(EmployeeResponsibility.EMERGENCY);
        assertFalse(gate.authenticateEmployee(employee1, employee2.employeeMagnetCard));
    }


}