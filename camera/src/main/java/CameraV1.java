public class CameraV1 {
    private static final CameraV1 instance = new CameraV1();
    public Port port;
    private CameraState state;

    public CameraV1() {
        port = new Port();
    }

    public static CameraV1 getInstance() {
        return instance;
    }

    public void innerOn() {
        state = CameraState.ON;
    }

    public void innerOff() {
        state = CameraState.OFF;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements ICamera {
        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        //TODO: add IComponentVisitor and logic
        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
