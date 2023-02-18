package components;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class VehicleKeyAESEncryption {
    public static final String autoXPassword = "AutoX23";
    public static final String zooxPassword = "ZooxSDC73";
    private static final SecretKeySpec key;

    static {
        key = new SecretKeySpec(new SecureRandom().generateSeed(32), "AES");
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
