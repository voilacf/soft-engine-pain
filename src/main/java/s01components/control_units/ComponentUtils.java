package s01components.control_units;

import java.lang.reflect.Method;

public class ComponentUtils {

    public static Object invokeMethod(Object component, String componentMethod, Class<?>[] parameters, Object... parameterValues) {
        try {
            Method m = component.getClass().getMethod(componentMethod, parameters);
            return m.invoke(component, parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object component, String componentMethod) {
        try {
            Method m = component.getClass().getMethod(componentMethod);
            return m.invoke(component);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
