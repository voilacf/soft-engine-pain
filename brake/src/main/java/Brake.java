public class Brake {
    private static final Brake instance = new Brake();
    public Port port;
    private double percentage;

    private Brake() {
        port = new Port();
    }

    public static Brake getInstance() {
        return instance;
    }

    public void innerSetBrake(double percentage) {
        this.percentage = percentage;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IBrake {

        public void setBrake(double percentage) {
            innerSetBrake(percentage);
        }

        //TODO: add IComponentVisitor and logic
        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
