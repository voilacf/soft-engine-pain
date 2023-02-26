package factories;

import application.ApplicationConfiguration;
import builder.*;
import components.Door;
import service_center.ServiceCenter;

import java.lang.reflect.Array;
import java.util.function.Supplier;

public class AutonomousVehicleFactory {
    private static <T> T[] arr(Supplier<T> o, int count) {
        T[] arr = (T[]) Array.newInstance(o.getClass(), count);
        for (int i = 0; i < count; i++) {
            arr[i] = o.get();
        }
        return arr;
    }

    public static AutonomousVehicle buildAmazonZoox(ServiceCenter serviceCenter, ApplicationConfiguration config) {
        return new AutonomousVehicle.Builder()
                .chassis(new Chassis())
                .engine(ComponentFactory.buildEngine(config.getEngine()))
                .battery(ComponentFactory.buildBattery())
                .headlights(arr(ComponentFactory::buildLED, 4))
                .brakeLights(arr(ComponentFactory::buildBrakeLight, 4))
                // Each indicator has states for both left and right
                // So these are only 2 objects but they manage 4 indicators
                .indicators(arr(ComponentFactory::buildIndicator, 2))
                .doors(arr(() -> new Door(serviceCenter), 4))
                .seats(arr(SeatBench::new, 2))
                .wheels(arr(Wheel::new, 4))
                .brakes(arr(ComponentFactory::buildBrake, 4))
                .gps(arr(ComponentFactory::buildGPS, 2))
                .cameras(arr(() -> ComponentFactory.buildCamera(config.getCamera()), 4))
                .lidars(arr(() -> ComponentFactory.buildLidar(config.getLidar()), 4))
                .type(VehicleType.AMAZON_ZOOX)
                .build();
    }

    public static AutonomousVehicle buildAutoX(ServiceCenter serviceCenter, ApplicationConfiguration config) {
        return new AutonomousVehicle.Builder()
                .chassis(new Chassis())
                .engine(ComponentFactory.buildEngine(config.getEngine()))
                .battery(ComponentFactory.buildBattery())
                .headlights(arr(ComponentFactory::buildLED, 2))
                .brakeLights(arr(ComponentFactory::buildBrakeLight, 2))
                // Each indicator has states for both left and right
                // So these are only 2 objects but they manage 4 indicators
                .indicators(arr(ComponentFactory::buildIndicator, 2))
                .doors(arr(() -> new Door(serviceCenter), 4))
                .seats(arr(Seat::new, 6))
                .wheels(arr(Wheel::new, 4))
                .brakes(arr(ComponentFactory::buildBrake, 8))
                .gps(arr(ComponentFactory::buildGPS, 2))
                .cameras(arr(() -> ComponentFactory.buildCamera(config.getCamera()), 2))
                .lidars(arr(() -> ComponentFactory.buildLidar(config.getLidar()), 4))
                .type(VehicleType.AUTOX)
                .build();
    }
}
