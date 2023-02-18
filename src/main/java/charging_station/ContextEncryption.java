package charging_station;

public class ContextEncryption {
    private IUserMemberCardEncryptionStrategy strategy;

    public ContextEncryption(IUserMemberCardEncryptionStrategy strategy){
        setStrategy(strategy);
    }
    public String executeEncryptionStrategy(String data){
        return getStrategy().encrypt(data);
    }
    public String executeDecryptionStrategy(String encryptedData){
        return getStrategy().decrypt(encryptedData);
    }

    public IUserMemberCardEncryptionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IUserMemberCardEncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}
