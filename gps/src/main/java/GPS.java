public class GPS {
    private static final GPS instance = new GPS();
    public Port port;
    private GPSState state;
    private String frequency;

    private GPS() {
        port = new Port();
    }

    public static GPS getInstance() {
        return instance;
    }

    private void innerOn() {
        state = GPSState.ON;
    }

    private void innerOff() {
        state = GPSState.OFF;
    }

    private void innerConnectSatellite(String frequency) {
        this.frequency = frequency;
    }

    private GPSState innerGetState(){
        return state;
    }

    //TODO: add visitor (s07)
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

        public String getState() {
            return innerGetState().toString().toLowerCase();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
