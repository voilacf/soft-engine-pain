package s06;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import s06chargingstation.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThenUserMemberCard extends Stage<ThenUserMemberCard> {
    @ExpectedScenarioState
    public User user;

    public ThenUserMemberCard theDecryptionOfPointsWillBeCorrectly(int expectedPoints) {
        String expected = String.valueOf(expectedPoints);

        String encryptedData = user.getUserMemberCard().getEncryptedLoyaltyPoints();
        String decryptedData = user.getUserMemberCard().getEncryptionStrategy().decryptLoyaltyPoints(encryptedData);

        assertEquals(expected, decryptedData);
        return self();
    }
}
