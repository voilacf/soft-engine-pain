package charging_station;

public interface IUserMemberCardEncryptionStrategy {
    String encrypt(String data);

    String decrypt(String encryptedData);
}
