public class LidarNG {
    private static final LidarNG instance = new LidarNG();
    public Port port;
    private LidarState state;

    public LidarNG() {
        port = new Port();
    }

    public static LidarNG getInstance() {
        return instance;
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
