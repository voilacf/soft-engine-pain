package charging_station;

public class Silver implements ILoyaltyState{
    //TODO check promote(UserMemberCard userMemberCard)
    @Override
    public void promote(UserMemberCard userMemberCard) {
        int minPointsForChange = 2000;

        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        int points = Integer.parseInt(loyaltyPoints);

        if(points >= minPointsForChange){
            userMemberCard.setLoyaltyState(new Gold());
            System.out.println("LoyaltyState changed: \tSILVER -> GOLD");
        }

    }
}
