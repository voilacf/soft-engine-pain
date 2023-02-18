package charging_station;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class UserMemberCardSHA256Encryption implements IUserMemberCardEncryptionStrategy{
    //TODO check encrypt(String data)
    @Override
    public String encrypt(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
