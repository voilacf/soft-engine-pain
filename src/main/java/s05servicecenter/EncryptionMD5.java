package s05servicecenter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionMD5 implements IEncryptionStrategy {

    @Override
    public String encrypt(char[][] data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte [] dataBytes = Arrays.deepToString(data).getBytes(StandardCharsets.UTF_8);
            byte[] hash = digest.digest(dataBytes);
            return Base64.getEncoder().encodeToString(hash);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


