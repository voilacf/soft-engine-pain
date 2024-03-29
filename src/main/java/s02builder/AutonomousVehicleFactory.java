package s02builder;

import s01components.ComponentFactory;
import s01components.application.ApplicationConfiguration;
import s03command.Door;
import s04observer.UltraSonicSensor;
import s05servicecenter.ServiceCenter;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class AutonomousVehicleFactory {
    private static <T> T[] arr(Class<?> clazz, Supplier<T> sup, int count) {
        T[] arr = (T[]) Array.newInstance(clazz, count);
        for (int i = 0; i < count; i++) {
            arr[i] = sup.get();
        }
        return arr;
    }

    public static AutonomousVehicle buildAmazonZoox(ServiceCenter serviceCenter, ApplicationConfiguration config) {
        AtomicInteger ultraSonicId = new AtomicInteger(1);
        return new AutonomousVehicle.Builder()
                .chassis(new Chassis())
                .engine(ComponentFactory.buildEngine(config.getEngine()))
                // (S03) The task is not clear about the battery count.
                // In S02 Builder it says that both amazon zoox and auto x should have 1 battery.
                // But in S03 Composite it says 8 batteries for amazon zoox.
                // Because these two are contradictory, the first specification was chosen.
                .battery(ComponentFactory.buildBattery())
                .headlights(arr(Object.class, ComponentFactory::buildLED, 4))
                .brakeLights(arr(Object.class, ComponentFactory::buildBrakeLight, 4))
                // Each indicator has states for both left and right
                // So these are only 2 objects but they manage 4 indicators
                .indicators(arr(Object.class, ComponentFactory::buildIndicator, 2))
                .doors(arr(Door.class, () -> new Door(serviceCenter), 4))
                .seats(arr(SeatBench.class, SeatBench::new, 2))
                .wheels(arr(Wheel.class, Wheel::new, 4))
                .brakes(arr(Object.class, ComponentFactory::buildBrake, 4))
                .gps(arr(Object.class, ComponentFactory::buildGPS, 2))
                .cameras(arr(Object.class, () -> ComponentFactory.buildCamera(config.getCamera()), 4))
                .lidars(arr(Object.class, () -> ComponentFactory.buildLidar(config.getLidar()), 4))
                .ultraSonics(arr(UltraSonicSensor.class, () -> new UltraSonicSensor(ultraSonicId.getAndIncrement()), 8))
                .type(VehicleType.AMAZON_ZOOX)
                .build();
    }

    public static AutonomousVehicle buildAutoX(ServiceCenter serviceCenter, ApplicationConfiguration config) {
        AtomicInteger ultraSonicId = new AtomicInteger(1);
        return new AutonomousVehicle.Builder()
                .chassis(new Chassis())
                .engine(ComponentFactory.buildEngine(config.getEngine()))
                // (S03) The task is not clear about the battery count.
                // In S02 Builder it says that both amazon zoox and auto x should have 1 battery.
                // But in S03 Composite it says 4 batteries for auto x.
                // Because these two are contradictory, the first specification was chosen.
                .battery(ComponentFactory.buildBattery())
                .headlights(arr(Object.class, ComponentFactory::buildLED, 2))
                .brakeLights(arr(Object.class, ComponentFactory::buildBrakeLight, 2))
                // Each indicator has states for both left and right
                // So these are only 2 objects but they manage 4 indicators
                .indicators(arr(Object.class, ComponentFactory::buildIndicator, 2))
                .doors(arr(Door.class, () -> new Door(serviceCenter), 4))
                .seats(arr(Seat.class, Seat::new, 6))
                .wheels(arr(Wheel.class, Wheel::new, 4))
                .brakes(arr(Object.class, ComponentFactory::buildBrake, 8))
                .gps(arr(Object.class, ComponentFactory::buildGPS, 2))
                .cameras(arr(Object.class, () -> ComponentFactory.buildCamera(config.getCamera()), 2))
                .lidars(arr(Object.class, () -> ComponentFactory.buildLidar(config.getLidar()), 4))
                .ultraSonics(arr(UltraSonicSensor.class, () -> new UltraSonicSensor(ultraSonicId.getAndIncrement()), 8))
                .type(VehicleType.AUTOX)
                .build();
    }
}
