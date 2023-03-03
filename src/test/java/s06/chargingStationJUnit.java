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
    private User userAES;
    private User userSHA;
    private ChargingStation chargingStation;
    private AutonomousVehicle autox;
    private AutonomousVehicle zoox;

    @BeforeEach
    public void setup() {
        ServiceCenter serviceCenter = new ServiceCenter();
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        this.chargingStation = new ChargingStation();
        this.userAES = new User(UUID.randomUUID().toString(), new UserMemberCardAESEncryption());
        this.userSHA = new User(UUID.randomUUID().toString(), new UserMemberCardSHA256Encryption());

        this.autox = AutonomousVehicleFactory.buildAutoX(serviceCenter, configuration);
        this.zoox = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, configuration);
    }

    @Test
    @Order(1)
    public void checkIfLoyaltyStateIsRightWithAES() {
        UserMemberCard userMemberCardAES = userAES.getUserMemberCard();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Blue);
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER - 1);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Blue);
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Silver);

        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD - 1);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Silver);
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Gold);

        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN - 1);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Gold);
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN);
        userMemberCardAES.getLoyaltyState().promote();
        assertTrue(userMemberCardAES.getLoyaltyState() instanceof Platin);
    }

    @Test
    @Order(2)
    public void checkIfLoyaltyStateIsRightWithSHA256() {
        UserMemberCard userMemberCardSHA = userSHA.getUserMemberCard();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Blue);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER - 1);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Blue);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Silver);

        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD - 1);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Silver);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Gold);

        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN - 1);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Gold);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN);
        userMemberCardSHA.getLoyaltyState().promote();
        assertTrue(userMemberCardSHA.getLoyaltyState() instanceof Platin);
    }


    @Test
    @Order(3)
    public void checkIfChargingWorks() {
        int amountOfEnergyBeforeCharging = chargingStation.getEnergyStack().size();
        int amountOfCharging = 50;
        chargingStation.charging(autox, userAES, amountOfCharging);
        chargingStation.charging(zoox, userAES, amountOfCharging);
        chargingStation.charging(autox, userSHA, amountOfCharging);
        chargingStation.charging(zoox, userSHA, amountOfCharging);

        assertEquals(amountOfEnergyBeforeCharging - (amountOfCharging * 4), chargingStation.getEnergyStack().size());
    }

    @Test
    @Order(4)
    public void checkRightCostOfEnergyBlue() {
        int amountOfCharging = 200;
        UserMemberCard userMemberCardAES = userAES.getUserMemberCard();
        UserMemberCard userMemberCardSHA = userSHA.getUserMemberCard();

        assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, amountOfCharging * 0.35, amountOfCharging));
        assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, amountOfCharging * 0.35, amountOfCharging));
    }

    @Test
    @Order(5)
    public void checkRightCostOfEnergySilver() {
        int amountOfCharging = 200;
        UserMemberCard userMemberCardAES = userAES.getUserMemberCard();
        UserMemberCard userMemberCardSHA = userSHA.getUserMemberCard();
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_SILVER);
        promoteToChosenLoyaltyState(MINIMUM_FOR_SILVER, userMemberCardAES);
        promoteToChosenLoyaltyState(MINIMUM_FOR_SILVER, userMemberCardSHA);

        assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging + 150)));
        assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging + 150)));
    }

    @Test
    @Order(6)
    public void checkRightCostOfEnergyGold() {
        int amountOfCharging = 200;
        UserMemberCard userMemberCardAES = userAES.getUserMemberCard();
        UserMemberCard userMemberCardSHA = userSHA.getUserMemberCard();
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_GOLD);

        promoteToChosenLoyaltyState(MINIMUM_FOR_GOLD, userMemberCardAES);
        promoteToChosenLoyaltyState(MINIMUM_FOR_GOLD, userMemberCardSHA);

        assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging * 2)));
        assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging * 2)));
    }

    @Test
    @Order(7)
    public void checkRightCostOfEnergyPlatin() {
        int amountOfCharging = 200;
        UserMemberCard userMemberCardAES = userAES.getUserMemberCard();
        UserMemberCard userMemberCardSHA = userSHA.getUserMemberCard();
        userMemberCardAES.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN);
        userMemberCardSHA.setEncryptedLoyaltyPoints(MINIMUM_FOR_PLATIN);
        promoteToChosenLoyaltyState(MINIMUM_FOR_PLATIN, userMemberCardAES);
        promoteToChosenLoyaltyState(MINIMUM_FOR_PLATIN, userMemberCardSHA);
        assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, 0, amountOfCharging));
        assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, 0, amountOfCharging));
        while (userMemberCardAES.getChargingSessionsWithPlatin() < 5) {
            assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging * 2)));
            assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, (amountOfCharging * 0.35), (amountOfCharging * 2)));
        }
        assertTrue(correctCreditsAndPoints(userMemberCardAES, amountOfCharging, 0, 0));
        assertTrue(correctCreditsAndPoints(userMemberCardSHA, amountOfCharging, 0, 0));
    }

    private boolean correctCreditsAndPoints(UserMemberCard userMemberCard, int amountOfCharging, double expectedCreditsReduce, int expectedPointsAdd) {
        double creditsBefore = Double.parseDouble(userMemberCard.getEncryptionStrategy().decryptCredits(userMemberCard.getEncryptedCredits()));
        int pointsBefore = Integer.parseInt(userMemberCard.getEncryptionStrategy().decryptLoyaltyPoints(userMemberCard.getEncryptedLoyaltyPoints()));

        if (userMemberCard.getEncryptionStrategy() instanceof UserMemberCardAESEncryption)
            chargingStation.charging(autox, userAES, amountOfCharging);
        else chargingStation.charging(zoox, userSHA, amountOfCharging);

        double creditsAfter = Double.parseDouble(userMemberCard.getEncryptionStrategy().decryptCredits(userMemberCard.getEncryptedCredits()));
        int pointsAfter = Integer.parseInt(userMemberCard.getEncryptionStrategy().decryptLoyaltyPoints(userMemberCard.getEncryptedLoyaltyPoints()));

        return ((creditsAfter == (creditsBefore - expectedCreditsReduce)) && (pointsAfter == (pointsBefore + expectedPointsAdd)));
    }

    private void promoteToChosenLoyaltyState(int loyaltyState, UserMemberCard userMemberCard) {
        switch (loyaltyState) {
            case MINIMUM_FOR_PLATIN:
                userMemberCard.getLoyaltyState().promote();
            case MINIMUM_FOR_GOLD:
                userMemberCard.getLoyaltyState().promote();
            case MINIMUM_FOR_SILVER:
                userMemberCard.getLoyaltyState().promote();
                break;
        }
    }
}
