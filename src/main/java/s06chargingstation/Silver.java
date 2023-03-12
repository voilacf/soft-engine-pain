package s06chargingstation;

public class Silver extends LoyaltyState {
    public Silver(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if (loyaltyPoints >= MINIMUM_FOR_GOLD) {
            userMemberCard.setLoyaltyState(new Gold(userMemberCard));
            System.out.println("LoyaltyState changed: \tSILVER -> GOLD");
        }
    }

    @Override
    public boolean addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        double costs = credits - (amountOfEnergy * 0.35);
        if (costs >= 0) {
            userMemberCard.setEncryptedCredits(costs);
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy + 150);
            System.out.println("Bill: \tcosts: " + amountOfEnergy * 0.35 + " Euro \tcollected loyaltyPoints: " + amountOfEnergy + 150 + " Points");
            return true;
        }
        return false;
    }
}
