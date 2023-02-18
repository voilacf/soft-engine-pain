import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class GPSFactory {
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToGPSJavaArchive + "gps.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, GPSFactory.class.getClassLoader());
            Class<?> gpsClass = Class.forName("GPS", true, urlClassLoader);
            Object gpsInstance = gpsClass.getMethod("getInstance").invoke(null);
            port = gpsClass.getDeclaredField("port").get(gpsInstance);
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
