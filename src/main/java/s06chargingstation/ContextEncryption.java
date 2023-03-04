package s06chargingstation;

public class ContextEncryption {
    private IUserMemberCardEncryptionStrategy strategy;

    public ContextEncryption(IUserMemberCardEncryptionStrategy strategy) {
        setStrategy(strategy);
    }

    public String executeEncryptionStrategy(String data) {
        return getStrategy().encrypt(data);
    }

    public String executeDecryptionStrategyLoyaltyPoints(String encryptedData) {
        return getStrategy().decryptLoyaltyPoints(encryptedData);
    }

    public String executeDecryptionStrategyCredits(String encryptedData) {
        return getStrategy().decryptCredits(encryptedData);
    }

    public IUserMemberCardEncryptionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IUserMemberCardEncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}
