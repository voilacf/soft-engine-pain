package charging_station;

public class ContextEncryption {
    private IUserMemberCardEncryptionStrategy strategy;

    public ContextEncryption(IUserMemberCardEncryptionStrategy strategy){
        setStrategy(strategy);
    }
    //TODO methode in vpp anpassen
    public String executeEncryptionStrategy(String data){
        return getStrategy().encrypt(data);
    }
    //TODO methode in vpp hinzufügen
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
