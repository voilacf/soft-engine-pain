public class Indicator{
    private static final Indicator instance = new Indicator();
    public Port port;
    private IndicatorState state;
    private IndicatorSide side;

    public Indicator(){
        port = new Port();
    }

    public void innerOn(IndicatorSide side){
        //TODO: this doesn't make as much sense yet, does it?
        switch (side){
            case LEFT :
                state = IndicatorState.ON;
                break;
            case RIGHT:
                state = IndicatorState.ON;
                break;
            case HAZARD:
                state = IndicatorState.ON;
                break;
        }
    }

    public void innerOff(IndicatorSide side){
        //TODO: this doesn't make as much sense yet, does it?
        switch (side){
            case LEFT :
                state = IndicatorState.OFF;
                break;
            case RIGHT:
                state = IndicatorState.OFF;
                break;
            case HAZARD:
                state = IndicatorState.OFF;
                break;
        }
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IIndicator{

        public void on(IndicatorSide side){
            innerOn(side);
        }

        public void off(IndicatorSide side){
            innerOff(side);
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }

}
