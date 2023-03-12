public interface IElectricEngine {
    void on();
    void off();
    void increaseRPM(int deltaRPM, int seconds);
    void decreaseRPM(int deltaRPM, int seconds);
    int computePowerDrawPerSecond();
    int getRPM();
    String getState();
    int getPowerDrawPerRotation();
    void setPowerProvider(Object powerProvider);
}
