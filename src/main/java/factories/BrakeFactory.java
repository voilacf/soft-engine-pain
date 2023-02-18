package factories;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class BrakeFactory {
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToBrakeJavaArchive + "brake.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BrakeFactory.class.getClassLoader());
            Class<?> brakeClass = Class.forName("Brake", true, urlClassLoader);
            Object brakeInstance = brakeClass.getMethod("getInstance").invoke(null);
            port = brakeClass.getDeclaredField("port").get(brakeInstance);
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
