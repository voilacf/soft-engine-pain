package s06chargingstation;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

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
