import java.lang.reflect.InvocationTargetException;

public class CameraV1 {
    private static final CameraV1 instance = new CameraV1();
    public Port port;
    private CameraState state;

    private CameraV1() {
        port = new Port();
    }

    public static CameraV1 getInstance() {
        return instance;
    }

    private void innerOn() {
        state = CameraState.ON;
    }

    private void innerOff() {
        state = CameraState.OFF;
    }

    private CameraState innerGetState(){
        return state;
    }

    public class Port implements ICamera {
        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public String getState(){
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public void accept(Object visitor) {
            try {
                visitor.getClass().getMethod("visitCamera", Object.class).invoke(visitor, this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
