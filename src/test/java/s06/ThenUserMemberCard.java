package s06;

import charging_station.User;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.junit.jupiter.api.Assertions.*;

public class ThenUserMemberCard extends Stage<ThenUserMemberCard> {
    @ExpectedScenarioState
    public User user;

    public ThenUserMemberCard theDecryptionOfPointsWillBeCorrectly(int expectedPoints){
        String expected = String.valueOf(expectedPoints);

        String encryptedData = user.getUserMemberCard().getEncryptedLoyaltyPoints();
        String decryptedData = user.getUserMemberCard().getEncryptionStrategy().decrypt(encryptedData);

        assertEquals(expected,decryptedData);
        return self();
    }
}
