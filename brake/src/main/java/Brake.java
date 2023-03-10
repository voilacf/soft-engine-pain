import java.lang.reflect.InvocationTargetException;

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

    public class Port implements IBrake {
        @Override
        public double getPercentage(){
            return innerGetPercentage();
        }

        @Override
        public void setBrake(double percentage) {
            innerSetBrake(percentage);
        }

        @Override
        public void accept(Object visitor) {
            try {
                visitor.getClass().getMethod("visitBrake", Object.class).invoke(visitor, this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
