import javax.naming.InitialContext;

public class Indicator {
    private static final Indicator instance = new Indicator();
    public Port port;
    private IndicatorState state;
    private IndicatorSide side;

    public Indicator() {
        port = new Port();
    }

    public static Indicator getInstance() {
        return instance;
    }

    public void innerOn(IndicatorSide side) {
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

        public void on(int sideEnumValue) {
            on(IndicatorSide.values()[sideEnumValue]);
        }

        public void off(int sideEnumValue) {
            off(IndicatorSide.values()[sideEnumValue]);
        }

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
