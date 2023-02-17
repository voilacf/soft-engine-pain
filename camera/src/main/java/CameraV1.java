public class CameraV1 implements ICamera{
    private CameraState state;

    public CameraV1(){
        state = CameraState.OFF;
    }

    public void on(){
        state = CameraState.ON;
    }

    public void off(){
        state = CameraState.OFF;
    }

    //void visit(IComponentVisitor visitor);
}
