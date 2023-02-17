package charging_station;

public class UserMemberCard {
    private IUserMemberCardEncryptionStrategy encryptionStrategy;
    private ILoyaltyState loyaltyState;
    private String encryptedLoyaltyPoints;
    private String encryptedCredits;
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
    }

    public String getEncryptedLoyaltyPoints() {
        return encryptedLoyaltyPoints;
    }

    public void setEncryptedLoyaltyPoints(String encryptedLoyaltyPoints) {
        this.encryptedLoyaltyPoints = encryptedLoyaltyPoints;
    }

    public String getEncryptedCredits() {
        return encryptedCredits;
    }

    public void setEncryptedCredits(String encryptedCredits) {
        this.encryptedCredits = encryptedCredits;
    }

    public int getChargingSessionSinceLastFreebie() {
        return chargingSessionSinceLastFreebie;
    }

    public void setChargingSessionSinceLastFreebie(int chargingSessionSinceLastFreebie) {
        this.chargingSessionSinceLastFreebie = chargingSessionSinceLastFreebie;
    }
}
