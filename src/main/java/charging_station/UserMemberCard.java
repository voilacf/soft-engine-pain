package charging_station;

public class UserMemberCard {
    private IUserMemberCardEncryptionStrategy encryptionStrategy;
    private ILoyaltyState loyaltyState;
    private String encryptedLoyaltyPoints;
    private String encryptedCredits;
    //TODO maybe add integer for charging sessions since loyalteState change ?
    private int chargingSessionSinceLastFreebie;

    public IUserMemberCardEncryptionStrategy getEncryptionStrategy() {
        return encryptionStrategy;
    }

    public void setEncryptionStrategy(IUserMemberCardEncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public ILoyaltyState getLoyaltyState() {
        return loyaltyState;
    }

    public void setLoyaltyState(ILoyaltyState loyaltyState) {
        this.loyaltyState = loyaltyState;
        setChargingSessionSinceLastFreebie(0);
    }

    public String getEncryptedLoyaltyPoints() {
        return encryptedLoyaltyPoints;
    }

    public void setEncryptedLoyaltyPoints(int loyaltyPoints) {
        ContextEncryption contextEncryption = new ContextEncryption(getEncryptionStrategy());
        this.encryptedLoyaltyPoints = contextEncryption.getStrategy().encrypt(String.valueOf(loyaltyPoints));
    }

    public String getEncryptedCredits() {
        return encryptedCredits;
    }

    public void setEncryptedCredits(int credits) {
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
