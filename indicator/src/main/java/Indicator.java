public class Indicator{
    private static final Indicator instance = new Indicator();
    public Port port;
    private IndicatorState state;
    private IndicatorSide side;

    public Indicator(){
        port = new Port();
    }

    public void innerOn(IndicatorSide side){

    }

    public void innerOff(IndicatorSide side){

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
