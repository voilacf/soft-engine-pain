package charging_station;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class UserMemberCardSHA256Encryption implements IUserMemberCardEncryptionStrategy {
    @Override
    public String encrypt(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String decrypt(String encryptedData) {
        String decrypedData = "";
        int expectedInt = 0;
        String expectedString;
        while (!encryptedData.equals(decrypedData)) {
            expectedString = String.valueOf(expectedInt);
            decrypedData = encrypt(expectedString);
        }
        return decrypedData;
    }
}
