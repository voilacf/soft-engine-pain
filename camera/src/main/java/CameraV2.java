public class CameraV2 implements ICamera{
    private CameraState state;

    public CameraV2(){
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
