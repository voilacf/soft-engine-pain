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

    private void innerSetBrake(double percentage) {
        this.percentage = percentage;
    }

    private double innerGetPercentage(){
        return this.percentage;
    }

    //public void innerVisit(IComponentVisitor visitor){}

    public class Port implements IBrake {
        @Override
        public double getPercentage(){
            return innerGetPercentage();
        }

        @Override
        public void setBrake(double percentage) {
            innerSetBrake(percentage);
        }

        //TODO: add IComponentVisitor and logic (s07)
        /*public void visit(IComponentVisitor visitor){
            innerVisit(visitor);
        }
        * */
    }
}
