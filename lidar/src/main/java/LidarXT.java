public class LidarXT {
    private LidarState state;

    public LidarXT(){
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
