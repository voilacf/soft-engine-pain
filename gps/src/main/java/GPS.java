import java.util.ArrayList;

public class GPS implements IGPS{
    private GPSState state;
    private ArrayList<String> frequency;

    public GPS(){
        state = GPSState.OFF;
    }

    public void on(){
        state = GPSState.ON;
    }

    public void off(){
        state = GPSState.OFF;
    }

    public void connectSatellite(String frequency){

    }

    //void visit(IComponentVisitor visitor);
}
