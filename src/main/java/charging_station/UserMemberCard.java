package charging_station;

public class UserMemberCard {
    private IUserMemberCardEncryptionStrategy encryptionStrategy;
    private LoyaltyState loyaltyState;
    private String encryptedLoyaltyPoints;
    private String encryptedCredits;
    private int chargingSessionSinceLastFreebie;

    public UserMemberCard(IUserMemberCardEncryptionStrategy encryptionStrategy){
        setEncryptionStrategy(encryptionStrategy);
        setLoyaltyState(new Blue(this));
        setEncryptedLoyaltyPoints(0);
        setEncryptedCredits(5000);
        setChargingSessionSinceLastFreebie(0);
    }

    public IUserMemberCardEncryptionStrategy getEncryptionStrategy() {
        return encryptionStrategy;
    }

    public void setEncryptionStrategy(IUserMemberCardEncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public LoyaltyState getLoyaltyState() {
        return loyaltyState;
    }

    //TODO check setLoyaltyState(...)
    public void setLoyaltyState(LoyaltyState loyaltyState) {
        this.loyaltyState = loyaltyState;
        setChargingSessionSinceLastFreebie(0);
    }

    public String getEncryptedLoyaltyPoints() {
        return encryptedLoyaltyPoints;
    }

    //TODO check setEncryptedLoyaltyPoints(...)
    public void setEncryptedLoyaltyPoints(int loyaltyPoints) {
        ContextEncryption contextEncryption = new ContextEncryption(getEncryptionStrategy());
        this.encryptedLoyaltyPoints = contextEncryption.getStrategy().encrypt(String.valueOf(loyaltyPoints));
    }

    public String getEncryptedCredits() {
        return encryptedCredits;
    }

    //TODO check setEncryptedCredits(...)
    public void setEncryptedCredits(double credits) {
        ContextEncryption contextEncryption = new ContextEncryption(getEncryptionStrategy());
        this.encryptedCredits = contextEncryption.getStrategy().encrypt(String.valueOf(credits));
    }

    public int getChargingSessionSinceLastFreebie() {
        return chargingSessionSinceLastFreebie;
    }

    public void setChargingSessionSinceLastFreebie(int chargingSessionSinceLastFreebie) {
        this.chargingSessionSinceLastFreebie = chargingSessionSinceLastFreebie;
    }
}
