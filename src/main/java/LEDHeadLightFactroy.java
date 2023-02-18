import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class LEDHeadLightFactroy {
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToLedHeadlightJavaArchive + "led-headlight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LEDHeadLightFactroy.class.getClassLoader());
            Class<?> ledClass = Class.forName("LED", true, urlClassLoader);
            Object ledInstance = ledClass.getMethod("getInstance").invoke(null);
            port = ledClass.getDeclaredField("port").get(ledInstance);
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
