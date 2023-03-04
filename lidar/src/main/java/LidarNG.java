public class LidarNG {
    private static final LidarNG instance = new LidarNG();
    public Port port;
    private LidarState state;

    private LidarNG() {
        port = new Port();
    }

    public static LidarNG getInstance() {
        return instance;
    }

    private void innerOn() {
        state = LidarState.ON;
    }

    private void innerOff() {
        state = LidarState.OFF;
    }

    private LidarState innerGetState() {
        return state;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements ILidar {
        @Override
        public String getState() {
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
