package s06chargingstation;

public interface IUserMemberCardEncryptionStrategy {
    String encrypt(String data);

    String decryptLoyaltyPoints(String encryptedData);

    String decryptCredits(String encryptedData);
}
