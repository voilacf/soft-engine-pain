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
    public String decryptLoyaltyPoints(String encryptedData) {
        String decrypedData = "";
        int expectedDouble = 0;
        String expectedString = "";
        while (!encryptedData.equals(decrypedData)) {
            expectedString = String.valueOf(expectedDouble);
            decrypedData = encrypt(expectedString);
            expectedDouble++;
        }
        System.out.println("finished decrypt loyalty Points");
        return expectedString;
    }

    @Override
    public String decryptCredits(String encryptedData) {
        String decrypedData = "";
        double expectedDouble = Math.round(5000*100.0)/100.0;
        String expectedString = "";
        while (!encryptedData.equals(decrypedData)) {
            expectedString = String.valueOf(expectedDouble);
            decrypedData = encrypt(expectedString);
            expectedDouble =Math.round((expectedDouble-0.01)*100.0)/100.0;
        }
        return expectedString;
    }
}
