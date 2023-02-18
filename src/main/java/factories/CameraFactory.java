package factories;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class CameraFactory {
    //TODO: add second camera factory -> V1 and V2
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToCameraJavaArchive + "camera.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CameraFactory.class.getClassLoader());
            Class<?> cameraClass = Class.forName("CameraV1", true, urlClassLoader);
            Object cameraInstance = cameraClass.getMethod("getInstance").invoke(null);
            port = cameraClass.getDeclaredField("port").get(cameraInstance);
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
