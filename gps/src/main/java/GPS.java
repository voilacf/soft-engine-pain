import java.util.ArrayList;

public class GPS {
    private static final GPS instance = new GPS();
    public Port port;
    private GPSState state;
    private ArrayList<String> frequency;

    public GPS() {
        port = new Port();
        frequency = new ArrayList<String>();
    }

    public void innerOn() {
        state = GPSState.ON;
    }

    public void innerOff() {
        state = GPSState.OFF;
    }

    public void innerConnectSatellite(String frequency) {
        this.frequency.add(frequency);
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IGPS {

        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        public void connectSatellite(String frequency) {
            innerConnectSatellite(frequency);
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
