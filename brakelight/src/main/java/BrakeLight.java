import java.lang.reflect.InvocationTargetException;

public class BrakeLight {
    private static final BrakeLight instance = new BrakeLight();
    public Port port;
    private BrakeLightState state;

    public BrakeLight() {
        port = new Port();
    }

    public static BrakeLight getInstance() {
        return instance;
    }

    private void innerOn() {
        state = BrakeLightState.ON;
    }

    private void innerOff() {
        state = BrakeLightState.OFF;
    }

    private BrakeLightState innerGetState(){
        return state;
    }

    public class Port implements IBrakeLight {

        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        public String getState(){
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public void accept(Object visitor) {
            try {
                visitor.getClass().getMethod("visitBrakeLight", Object.class).invoke(visitor, this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
