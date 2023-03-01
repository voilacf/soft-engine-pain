package s06;

import application.ApplicationConfiguration;
import builder.AutonomousVehicle;
import charging_station.*;
import factories.AutonomousVehicleFactory;
import org.junit.jupiter.api.*;
import service_center.ServiceCenter;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class chargingStationJUnit {
    protected static final int MINIMUM_FOR_SILVER = 500;
    protected static final int MINIMUM_FOR_GOLD = 2000;
    protected static final int MINIMUM_FOR_PLATIN = 10000;
    AutonomousVehicle zoox;
    AutonomousVehicle autox;
    private User userAES;
    private User userSHA;
    private ChargingStation chargingStation;
    private ServiceCenter serviceCenter;
    private ApplicationConfiguration configuration;

    @BeforeEach
    public void setup() {
        this.serviceCenter = new ServiceCenter();
        this.configuration = new ApplicationConfiguration();
        //this.zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
        this.autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);

        this.chargingStation = new ChargingStation();
        this.userAES = new User(UUID.randomUUID().toString(), new UserMemberCardAESEncryption());
        this.userSHA = new User(UUID.randomUUID().toString(), new UserMemberCardSHA256Encryption());
    }

    @Test
    @Order(1)
    public void checkIfLoyaltyStateIsRight() {
        UserMemberCard userMemberCard = userAES.getUserMemberCard();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Blue);
        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER - 1);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Blue);
        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Silver);

        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD - 1);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Silver);
        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Gold);

        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN - 1);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Gold);
        userMemberCard.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN);
        userMemberCard.getLoyaltyState().promote();
        assertTrue(userMemberCard.getLoyaltyState() instanceof Platin);
    }

    @Test
    @Order(2)
    public void checkIfSHA256DecryptionWorks() {
        UserMemberCard userMemberCard = userSHA.getUserMemberCard();
        userMemberCard.setEncryptedLoyaltyPoints(5);
        String encryptedData = userMemberCard.getEncryptedLoyaltyPoints();
        String decryptedData = userMemberCard.getEncryptionStrategy().decrypt(encryptedData);
        assertEquals("5", decryptedData);
    }

    @Test
    @Order(3)
    public void checkIfChargingWorks() {
        int amountOfEnergyBeforeCharging = chargingStation.getEnergyStack().size();
        int amountOfCharging = 50;
        //TODO fix test at the moment error at building AutonomousVehicle
        chargingStation.charging(autox, userAES, amountOfCharging);
        assertEquals(amountOfEnergyBeforeCharging - amountOfCharging, chargingStation.getEnergyStack().size());
    }
}
