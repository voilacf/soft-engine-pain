package factories;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class BrakeLightFactory {
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToBrakeLightJavaArchive + "brakelight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BrakeLightFactory.class.getClassLoader());
            Class<?> brakelightClass = Class.forName("BrakeLight", true, urlClassLoader);
            Object brakelightInstance = brakelightClass.getMethod("getInstance").invoke(null);
            port = brakelightClass.getDeclaredField("port").get(brakelightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return port;
    }

    public static void main(String... args) {
        Object port = build();
        System.out.println("port   | " + port.hashCode());

        try {
            Method onMethod = port.getClass().getMethod("on");
            System.out.println(onMethod);

            /*BatteryState result = (BatteryState) onMethod.invoke(port);
            System.out.println("result | " + result);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
