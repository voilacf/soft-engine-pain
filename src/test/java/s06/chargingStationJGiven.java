package s06;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class chargingStationJGiven extends ScenarioTest<GivenUserMemberCard, WhenUserMemberCard, ThenUserMemberCard> {
    @Test
    public void checkAESEncryption(){
        int loyaltyPoints = 555;
        given().cardWithSelectedEncryption(KindOfEncryption.AES);
        when().cardGetsSomeAmountOfPoints(loyaltyPoints);
        then().theDecryptionOfPointsWillBeCorrectly(loyaltyPoints);
    }

    @Test
    public void checkSHA256Encryption(){
        int loyaltyPoints = 54321;
        given().cardWithSelectedEncryption(KindOfEncryption.SHA256);
        when().cardGetsSomeAmountOfPoints(loyaltyPoints);
        then().theDecryptionOfPointsWillBeCorrectly(loyaltyPoints);
    }
}
