package charging_station;

public class Blue implements ILoyaltyState{
    //TODO check promote(UserMemberCard userMemberCard)
    @Override
    public void promote(UserMemberCard userMemberCard) {
        int minPointsForChange = 500;

        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        int points = Integer.parseInt(loyaltyPoints);

        if(points >= minPointsForChange){
            userMemberCard.setLoyaltyState(new Silver());
            System.out.println("LoyaltyState changed: \tBLUE -> SILVER");
        }

    }
}
