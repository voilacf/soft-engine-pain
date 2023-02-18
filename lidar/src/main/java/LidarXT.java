public class LidarXT {
    private static final LidarXT instance = new LidarXT();
    public Port port;
    private LidarState state;

    public LidarXT() {
        port = new Port();
    }

    public void innerOn() {
        state = LidarState.ON;
    }

    public void innerOff() {
        state = LidarState.OFF;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements ILidar {

        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
