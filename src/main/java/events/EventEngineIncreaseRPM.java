package events;

public class EventEngineIncreaseRPM {
    private int deltaRPM;
    private int seconds;

    public EventEngineIncreaseRPM(int deltaRPM, int seconds){
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

}