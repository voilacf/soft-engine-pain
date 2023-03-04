package s06;

import s06chargingstation.User;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class WhenUserMemberCard extends Stage<WhenUserMemberCard> {
    @ExpectedScenarioState
    public User user;

    public WhenUserMemberCard cardGetsSomeAmountOfPoints(int amountOfPoints) {
        user.getUserMemberCard().setEncryptedLoyaltyPoints(amountOfPoints);
        return self();
    }
}
