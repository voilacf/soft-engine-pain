package factories;

import application.CameraComponentType;
import application.EngineComponentType;
import application.LidarComponentType;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class Factory {
    private static HashMap<String, URL> jarPaths;

    private static Object build(String classname) {
        Object port = null;
        try {
            URL url = jarPaths.get(classname);
            if(!verify(url.getPath())){
                throw new RuntimeException("Jar not verified");
            }
            URL[] urls = {url};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Factory.class.getClassLoader());
            Class<?> brakeClass = Class.forName(classname, true, urlClassLoader);
            Object brakeInstance = brakeClass.getMethod("getInstance").invoke(null);
            port = brakeClass.getDeclaredField("port").get(brakeInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }

    public static Object buildBattery(){
        return build("Battery");
    }

    public static Object buildBrake(){
        return build("Brake");
    }

    public static Object buildBrakeLight(){
        return build("BrakeLight");
    }

    public static Object buildCamera(CameraComponentType type){
        if(CameraComponentType.CAMERA_V1 == type){
            return build("CameraV1");
        }else{
            return build("CameraV2");
        }
    }

    public static Object buildEngine(EngineComponentType type){
        if(EngineComponentType.ENGINE_NG == type){
            return build("ElectricEngineNG");
        }else{
            return build("ElectricEngineXT");
        }
    }

    public static Object buildGPS(){
        return build("GPS");
    }

    public static Object buildIndicator(){
        return build("Indicator");
    }

    public static Object buildLED(){
        return build("LED");
    }

    public static Object buildLidar(LidarComponentType type){
        if(LidarComponentType.LIDAR_NG == type){
            return build("LidarNG");
        }else{
            return build("LidarXT");
        }
    }

    private static boolean verify(String pathToJar){
        String curOs = System.getProperty("os.name");
        boolean isVerified = false;
        ProcessBuilder pb = null;
        // call the jarsigner depending on the operating system
        if(curOs.startsWith("Linux")){
            pb = new ProcessBuilder("jarsigner", "-verify", pathToJar);
        } else if(curOs.startsWith("Windows")){
            pb = new ProcessBuilder("C:\\Program Files\\Java\\jdk-17.0.5\\bin\\jarsigner", "-verify", pathToJar);
        } else {
            return isVerified;
        }
        // go through the output of the jarsigner command and return true if the "verify" is in any of the lines
        try {
            Process p = pb.start();
            InputStream iS = p.getInputStream();
            InputStreamReader iSR = new InputStreamReader(iS);
            BufferedReader bR = new BufferedReader(iSR);
            String line;
            while((line = bR.readLine()) != null){
                if (line.contains("verified")){
                    isVerified = true;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            return isVerified;
        }
        return isVerified;
    }

    static{
        jarPaths = new HashMap<>();
        try{
            jarPaths.put("Battery",new File(Configuration.INSTANCE.pathToBatteryJavaArchive + "battery.jar").toURI().toURL());
            jarPaths.put("Brake",new File(Configuration.INSTANCE.pathToBrakeJavaArchive + "brake.jar").toURI().toURL());
            jarPaths.put("BrakeLight",new File(Configuration.INSTANCE.pathToBrakeLightJavaArchive + "brakelight.jar").toURI().toURL());
            jarPaths.put("CameraV1",new File(Configuration.INSTANCE.pathToCameraJavaArchive + "camera.jar").toURI().toURL());
            jarPaths.put("CameraV2",new File(Configuration.INSTANCE.pathToCameraJavaArchive + "camera.jar").toURI().toURL());
            jarPaths.put("ElectricEngineNG",new File(Configuration.INSTANCE.pathToElectricEngineJavaArchive + "electric-engine.jar").toURI().toURL());
            jarPaths.put("ElectricEngineX",new File(Configuration.INSTANCE.pathToElectricEngineJavaArchive + "electric-engine.jar").toURI().toURL());
            jarPaths.put("GPS",new File(Configuration.INSTANCE.pathToGPSJavaArchive + "gps.jar").toURI().toURL());
            jarPaths.put("Indicator",new File(Configuration.INSTANCE.pathToIndicatorJavaArchive + "indicator.jar").toURI().toURL());
            jarPaths.put("LED",new File(Configuration.INSTANCE.pathToLedHeadlightJavaArchive + "led-headlight.jar").toURI().toURL());
            jarPaths.put("LidarNG",new File(Configuration.INSTANCE.pathToLidarJavaArchive + "lidar.jar").toURI().toURL());
            jarPaths.put("LidarXT",new File(Configuration.INSTANCE.pathToLidarJavaArchive + "lidar.jar").toURI().toURL());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        Object port = buildGPS();
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
