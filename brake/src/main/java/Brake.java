public class Brake{
    // static instance
    private static final Brake instance = new Brake();
    // port
    public Port port;

    private double percentage;

    private Brake() {
        port = new Port();
    }

    public void innerSetBrake(double percentage){
        this.percentage = percentage;
    }
    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IBrake{

        public void setBrake(double percentage) {
            innerSetBrake(percentage);
        }

        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */

    }
}
