package s06;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s06chargingstation.User;
import s06chargingstation.UserMemberCardAESEncryption;
import s06chargingstation.UserMemberCardSHA256Encryption;

import java.util.UUID;

public class GivenUserMemberCard extends Stage<GivenUserMemberCard> {
    @ProvidedScenarioState
    public User user;

    public GivenUserMemberCard cardWithSelectedEncryption(KindOfEncryption kindOfEncryption) {
        if (kindOfEncryption == KindOfEncryption.SHA256)
            user = new User(UUID.randomUUID().toString(), new UserMemberCardSHA256Encryption());
        else if (kindOfEncryption == KindOfEncryption.AES) {
            user = new User(UUID.randomUUID().toString(), new UserMemberCardAESEncryption());
        }
        return self();
    }
}
