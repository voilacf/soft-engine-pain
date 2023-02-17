package bridge;

public interface IElectricEngine {
    void on();
    void off();
    void increaseRPM(int deltaRPM, int seconds);
    void decreaseRPM(int deltaRPM, int seconds);
    public int computePowerDrawPerSecond();
}
