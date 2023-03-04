public class CameraV2 {
    private static final CameraV2 instance = new CameraV2();
    public Port port;
    private CameraState state;

    private CameraV2() {
        port = new Port();
    }

    public static CameraV2 getInstance() {
        return instance;
    }

    private void innerOn() {
        state = CameraState.ON;
    }

    private void innerOff() {
        state = CameraState.OFF;
    }

    private CameraState innerGetState() {
        return state;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements ICamera {
        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public String getState(){
            return innerGetState().toString().toLowerCase();
        }

        //TODO: add IComponentVisitor and logic (s07)
        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
