import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class LidarFactory {
    //TODO: add second factory for LidarNG?
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToLidarJavaArchive + "lidar.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LidarFactory.class.getClassLoader());
            Class<?> lidarClass = Class.forName("LidarXT", true, urlClassLoader);
            Object lidarInstance = lidarClass.getMethod("getInstance").invoke(null);
            port = lidarClass.getDeclaredField("port").get(lidarInstance);
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
