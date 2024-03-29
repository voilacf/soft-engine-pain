package s01components;

import s01components.application.CameraComponentType;
import s01components.application.EngineComponentType;
import s01components.application.LidarComponentType;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class ComponentFactory {
    private static final HashMap<String, String> jarPaths;
    private static final ArrayList<String> verifiedJars = new ArrayList<>();

    static {
        jarPaths = new HashMap<>();
        try {
            jarPaths.put("Battery", Configuration.INSTANCE.pathToBatteryJavaArchive + "battery.jar");
            jarPaths.put("Brake", Configuration.INSTANCE.pathToBrakeJavaArchive + "brake.jar");
            jarPaths.put("BrakeLight", Configuration.INSTANCE.pathToBrakeLightJavaArchive + "brakelight.jar");
            jarPaths.put("CameraV1", Configuration.INSTANCE.pathToCameraJavaArchive + "camera.jar");
            jarPaths.put("CameraV2", Configuration.INSTANCE.pathToCameraJavaArchive + "camera.jar");
            jarPaths.put("ElectricEngineNG", Configuration.INSTANCE.pathToElectricEngineJavaArchive + "electric-engine.jar");
            jarPaths.put("ElectricEngineX", Configuration.INSTANCE.pathToElectricEngineJavaArchive + "electric-engine.jar");
            jarPaths.put("GPS", Configuration.INSTANCE.pathToGPSJavaArchive + "gps.jar");
            jarPaths.put("Indicator", Configuration.INSTANCE.pathToIndicatorJavaArchive + "indicator.jar");
            jarPaths.put("LED", Configuration.INSTANCE.pathToLedHeadlightJavaArchive + "led-headlight.jar");
            jarPaths.put("LidarNG", Configuration.INSTANCE.pathToLidarJavaArchive + "lidar.jar");
            jarPaths.put("LidarXT", Configuration.INSTANCE.pathToLidarJavaArchive + "lidar.jar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object build(String classname) {
        Object port = null;
        try {
            String path = jarPaths.get(classname);
            if (!verify(path)) {
                throw new RuntimeException("Jar not verified");
            }
            URL[] urls = {new File(path).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ComponentFactory.class.getClassLoader());
            Class<?> brakeClass = Class.forName(classname, true, urlClassLoader);
            Object brakeInstance = brakeClass.getMethod("getInstance").invoke(null);
            port = brakeClass.getDeclaredField("port").get(brakeInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }

    private static boolean verify(String pathToJar) {
        if (verifiedJars.contains(pathToJar)) {
            return true;
        }

        String curOs = System.getProperty("os.name");
        boolean isVerified = false;
        ProcessBuilder pb = null;
        // call the jarsigner depending on the operating system
        if (curOs.startsWith("Windows")) {
            pb = new ProcessBuilder("C:\\Program Files\\Java\\jdk-17.0.5\\bin\\jarsigner", "-verify", pathToJar);
        } else {
            pb = new ProcessBuilder("jarsigner", "-verify", pathToJar);
        }

        // go through the output of the jarsigner command and return true if the "verify" is in any of the lines
        try {
            Process p = pb.start();
            InputStream iS = p.getInputStream();
            InputStreamReader iSR = new InputStreamReader(iS);
            BufferedReader bR = new BufferedReader(iSR);
            String line;
            while ((line = bR.readLine()) != null) {
                if (line.contains("verified") || line.contains("verifiziert")) {
                    isVerified = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return isVerified;
        }

        if (isVerified) {
            verifiedJars.add(pathToJar);
        }

        return isVerified;
    }

    public static Object buildBattery() {
        return build("Battery");
    }

    public static Object buildBrake() {
        return build("Brake");
    }

    public static Object buildBrakeLight() {
        return build("BrakeLight");
    }

    public static Object buildCamera(CameraComponentType type) {
        if (CameraComponentType.CAMERA_V1 == type) {
            return build("CameraV1");
        } else {
            return build("CameraV2");
        }
    }

    public static Object buildEngine(EngineComponentType type) {
        if (EngineComponentType.ENGINE_NG == type) {
            return build("ElectricEngineNG");
        } else {
            return build("ElectricEngineX");
        }
    }

    public static Object buildGPS() {
        return build("GPS");
    }

    public static Object buildIndicator() {
        return build("Indicator");
    }

    public static Object buildLED() {
        return build("LED");
    }

    public static Object buildLidar(LidarComponentType type) {
        if (LidarComponentType.LIDAR_NG == type) {
            return build("LidarNG");
        } else {
            return build("LidarXT");
        }
    }
}
