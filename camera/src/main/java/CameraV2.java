public class CameraV2{
    // static instance
    private static final CameraV1 instance = new CameraV1();
    // port
    public Port port;
    private CameraState state;

    public CameraV2(){
        port = new Port();
    }

    public void innerOn(){
        state = CameraState.ON;
    }

    public void innerOff(){
        state = CameraState.OFF;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements ICamera{

        public void on(){
            innerOn();
        }

        public void off(){
            innerOff();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */

    }
}
