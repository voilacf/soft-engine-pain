package s06chargingstation;

public class Platin extends LoyaltyState {
    public Platin(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    @Override
    public void promote() {
    }

    @Override
    public boolean addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        double costs = 0;
        if (userMemberCard.getChargingSessionsWithPlatin() == 0) {
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy);
            System.out.println("Bill: \tcosts: 0,0 Euro \tcollected loyaltyPoints: " + amountOfEnergy + " Points");
        } else if ((userMemberCard.getChargingSessionsWithPlatin() % 5) == 0) {
            System.out.println("Bill: \tcosts: 0,0 Euro \tcollected loyaltyPoints: 0");
        } else {
            costs = credits - (amountOfEnergy * 0.35);
            if (costs >= 0) {
                userMemberCard.setEncryptedCredits(costs);
                userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy * 2);
                System.out.println("Bill: \tcosts: " + amountOfEnergy * 0.35 + " Euro \tcollected loyaltyPoints: " + (amountOfEnergy * 2) + " Points");
            }
        }
        if (costs >= 0) {
            userMemberCard.setChargingSessionsWithPlatin(userMemberCard.getChargingSessionsWithPlatin() + 1);
            return true;
        }
        return false;
    }
}
