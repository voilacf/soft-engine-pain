package s06chargingstation;

public class Gold extends LoyaltyState {
    public Gold(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if (loyaltyPoints >= MINIMUM_FOR_PLATIN) {
            userMemberCard.setLoyaltyState(new Platin(userMemberCard));
            System.out.println("LoyaltyState changed: \tGOLD -> PLATIN");
        }
    }

    @Override
    public boolean addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        double costs = credits - (amountOfEnergy * 0.35);
        if (costs >= 0) {
            userMemberCard.setEncryptedCredits(costs);
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy * 2);
            System.out.println("Bill: \tcosts: " + amountOfEnergy * 0.35 + " Euro \tcollected loyaltyPoints: " + amountOfEnergy * 2 + " Points");
            return true;
        }
        return false;
    }
}
