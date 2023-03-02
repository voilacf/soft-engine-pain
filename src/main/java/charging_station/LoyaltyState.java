package charging_station;

public abstract class LoyaltyState {
    protected static final int MINIMUM_FOR_SILVER = 500;
    protected static final int MINIMUM_FOR_GOLD = 2000;
    protected static final int MINIMUM_FOR_PLATIN = 10000;

    protected final UserMemberCard userMemberCard;

    public LoyaltyState(UserMemberCard userMemberCard) {
        this.userMemberCard = userMemberCard;
    }

    public abstract void promote();

    public abstract boolean addCharging(int amountOfEnergy);

    protected int decryptLoyaltyPoints() {
        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        return Integer.parseInt(loyaltyPoints);
    }

    protected double decryptCredits() {
        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String credits = userMemberCard.getEncryptedCredits();
        credits = contextEncryption.executeDecryptionStrategy(credits);
        return Double.parseDouble(credits);
    }
}
