package charging_station;

//TODO change ILoyaltyState in vpp from interface to abstract
public abstract class LoyaltyState {
    protected final UserMemberCard userMemberCard;
    public LoyaltyState(UserMemberCard userMemberCard){
        this.userMemberCard = userMemberCard;
    }
    public abstract void promote();
}
