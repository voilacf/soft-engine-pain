package charging_station;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UserMemberCardAESEncryption implements IUserMemberCardEncryptionStrategy {

    private final String secretKey = "dhbw2022!";
    private final String salt = "sweet";
    private final byte[] iv = {0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1};

    //TODO check encrypt(String data)
    @Override
    public String encrypt(String data) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            SecretKeySpec secretKeySpecification = new SecretKeySpec(factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(),
                    salt.getBytes(), 65536, 256)).getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecification, new IvParameterSpec(this.iv));

            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    //TODO check decrypt(String data)
    @Override
    public String decrypt(String encryptedData) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKeySpec secretKeySpecification = new SecretKeySpec(factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(),
                    salt.getBytes(), 65536, 256)).getEncoded(), "AES");

            Cipher cipherInstance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipherInstance.init(Cipher.DECRYPT_MODE, secretKeySpecification, new IvParameterSpec(iv));

            return new String(cipherInstance.doFinal(Base64.getDecoder().decode(encryptedData)));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
