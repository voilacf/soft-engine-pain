package s07autonomousworkshop;

import s01components.ComponentFactory;
import s01components.application.ApplicationConfiguration;

import java.util.Arrays;
import java.util.Stack;

public class ComponentStorage {
    private final ComponentType type;
    private final Stack<Object> components = new Stack<>();
    private final Stack<Object> defectiveComponents = new Stack<>();

    public ComponentStorage(ComponentType type) {
        this.type = type;

        Object[] initialComponents = new Object[5];
        for (int i = 0; i < initialComponents.length; i++) {
            initialComponents[i] = switch (type) {
                case LED -> ComponentFactory.buildLED();
                case INDICATOR -> ComponentFactory.buildIndicator();
                case BRAKELIGHT -> ComponentFactory.buildBrakeLight();
                case BRAKE -> ComponentFactory.buildBrake();
                case GPS -> ComponentFactory.buildGPS();
                case LIDAR -> ComponentFactory.buildLidar(ApplicationConfiguration.getInstance().getLidar());
                case CAMERA -> ComponentFactory.buildCamera(ApplicationConfiguration.getInstance().getCamera());
            };
        }
        components.addAll(Arrays.asList(initialComponents));
    }

    public ComponentType getType() {
        return type;
    }

    public Object getNewComponent() {
        if (components.isEmpty()) {
            return null;
        }
        System.out.println("New component of type " + type + " was taken from storage");
        return components.pop();
    }

    public void addDefectiveComponent(Object component) {
        defectiveComponents.push(component);
        System.out.println("Defective component of type " + type + " was added to storage");
    }
}
