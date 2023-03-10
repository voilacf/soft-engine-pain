import java.lang.reflect.InvocationTargetException;

public class LidarXT {
    private static final LidarXT instance = new LidarXT();
    public Port port;
    private LidarState state;

    private LidarXT() {
        port = new Port();
    }

    public static LidarXT getInstance() {
        return instance;
    }

    private void innerOn() {
        state = LidarState.ON;
    }

    private void innerOff() {
        state = LidarState.OFF;
    }

    private LidarState innerGetState() {
        return state;
    }

    public class Port implements ILidar {
        @Override
        public String getState() {
            return innerGetState().toString().toLowerCase();
        }

        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public void accept(Object visitor) {
            try {
                visitor.getClass().getMethod("visitLidar", Object.class).invoke(visitor, this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
