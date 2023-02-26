public interface IBattery {
    int getEnergy();

    int useEnergy(int count);
    
    int storeEnergy(int count);
}
