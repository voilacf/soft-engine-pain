public class LidarNG {
    private LidarState state;

    public LidarNG(){
        state = LidarState.OFF;
    }

    public void on(){
        state = LidarState.ON;
    }

    public void off(){
        state = LidarState.OFF;
    }

    //public void visit(IComponentVisitor visitor){}
}
