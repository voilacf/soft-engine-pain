public class Indicator {
    private static final Indicator instance = new Indicator();
    public Port port;
    private IndicatorState state;
    private IndicatorSide side;

    public Indicator() {
        port = new Port();
    }

    public void innerOn(IndicatorSide side) {
        //TODO: good like this?
        switch (side) {
            case LEFT:
                state = IndicatorState.LEFT_ON;
                break;
            case RIGHT:
                state = IndicatorState.RIGHT_ON;
                break;
            case HAZARD:
                state = IndicatorState.ON;
                break;
            default:
                throw new RuntimeException("Error");
        }
    }

    public void innerOff(IndicatorSide side) {
        //TODO: good like this?
        switch (side) {
            case LEFT:
                state = IndicatorState.LEFT_OFF;
                break;
            case RIGHT:
                state = IndicatorState.RIGHT_OFF;
                break;
            case HAZARD:
                state = IndicatorState.OFF;
                break;
            default:
                throw new RuntimeException("Error");
        }
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IIndicator {

        public void on(IndicatorSide side) {
            innerOn(side);
        }

        public void off(IndicatorSide side) {
            innerOff(side);
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }

}
