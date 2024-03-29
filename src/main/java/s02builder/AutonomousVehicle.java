package s02builder;

import s01components.control_units.*;
import s02bridge.EnginePowerProvider;
import s03command.Door;
import s03facade.VehicleControlUnit;
import s04observer.UltraSonicSensor;
import s07autonomousworkshop.LiftingPlatform;

public class AutonomousVehicle {
    private static int idCounter = 1;
    private final int id;
    private final Chassis chassis;
    private final Object engine;
    private final Object battery; //IBattery
    private final Object[] headlights; //ILED
    private final Object[] brakeLights; //IBrakeLight
    private final Object[] indicators; //IIndicator
    private final Door[] doors;
    private final ISittable[] seats;
    private final Wheel[] wheels;
    private final Object[] brakes; //IBrake
    private final Object[] gps; //IGPS
    private final Object[] cameras; //ICamera
    private final Object[] lidars; //ILidar
    private final UltraSonicSensor[] ultraSonics;
    private final VehicleType type;

    private final VehicleControlUnit controlUnit;
    private final BatteryControlUnit batteryControlUnit;
    private final BrakeControlUnit brakeControlUnit;
    private final BrakeLightControlUnit brakeLightControlUnit;
    private final CameraControlUnit cameraControlUnit;
    private final EngineControlUnit engineControlUnit;
    private final GPSControlUnit gpsControlUnit;
    private final IndicatorControlUnit indicatorControlUnit;
    private final HeadlightControlUnit headlightControlUnit;
    private final LidarControlUnit lidarControlUnit;
    private final EnginePowerProvider enginePowerProvider;

    private AutonomousVehicle(Builder builder) {
        id = idCounter++;
        chassis = builder.chassis;
        engine = builder.engine;
        battery = builder.battery;
        headlights = builder.headlights;
        brakeLights = builder.brakeLights;
        indicators = builder.indicators;
        doors = builder.doors;
        seats = builder.seats;
        wheels = builder.wheels;
        brakes = builder.brakes;
        gps = builder.gps;
        cameras = builder.cameras;
        lidars = builder.lidars;
        ultraSonics = builder.ultraSonics;
        type = builder.type;

        controlUnit = new VehicleControlUnit(this);
        batteryControlUnit = new BatteryControlUnit();
        brakeControlUnit = new BrakeControlUnit(brakes);
        brakeLightControlUnit = new BrakeLightControlUnit(brakeLights);
        cameraControlUnit = new CameraControlUnit(cameras);
        engineControlUnit = new EngineControlUnit(engine);
        gpsControlUnit = new GPSControlUnit(gps);
        indicatorControlUnit = new IndicatorControlUnit(indicators);
        headlightControlUnit = new HeadlightControlUnit(headlights);
        lidarControlUnit = new LidarControlUnit(lidars);

        controlUnit.addSubscriber(batteryControlUnit);
        controlUnit.addSubscriber(brakeControlUnit);
        controlUnit.addSubscriber(brakeLightControlUnit);
        controlUnit.addSubscriber(cameraControlUnit);
        controlUnit.addSubscriber(engineControlUnit);
        controlUnit.addSubscriber(gpsControlUnit);
        controlUnit.addSubscriber(indicatorControlUnit);
        controlUnit.addSubscriber(headlightControlUnit);
        controlUnit.addSubscriber(lidarControlUnit);

        enginePowerProvider = new EnginePowerProvider(engine, battery);
        ComponentUtils.invokeMethod(engine, "setPowerProvider", new Class[]{Object.class}, enginePowerProvider);
    }

    public VehicleType getType() {
        return type;
    }

    public Door[] getDoors() {
        return doors;
    }

    public UltraSonicSensor[] getUltraSonics() {
        return ultraSonics;
    }

    public VehicleControlUnit getControlUnit() {
        return controlUnit;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public Object getEngine() {
        return engine;
    }

    public ISittable[] getSeats() {
        return seats;
    }

    public Object getBattery() {
        return battery;
    }

    public Object[] getHeadlights() {
        return headlights;
    }

    public Object[] getIndicators() {
        return indicators;
    }

    public Object[] getBrakeLights() {
        return brakeLights;
    }

    public Object[] getBrakes() {
        return brakes;
    }

    public Object[] getGps() {
        return gps;
    }

    public Object[] getLidars() {
        return lidars;
    }

    public Object[] getCameras() {
        return cameras;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void driveOntoLiftingPlatform(LiftingPlatform liftingPlatform) {
        liftingPlatform.driveOnTo(this);
    }

    @Override
    public String toString() {
        if (type == VehicleType.AUTOX)
            return "AutoX " + id;
        else
            return "Amazon Zoox " + id;
    }

    public static class Builder {
        private Chassis chassis;
        private Object engine;
        private Object battery; //IBattery
        private Object[] headlights; //ILED
        private Object[] brakeLights; //IBrakeLight
        private Object[] indicators; //IIndicator
        private Door[] doors;
        private ISittable[] seats;
        private Wheel[] wheels;
        private Object[] brakes; //IBrake
        private Object[] gps; //IGPS
        private Object[] cameras; //ICamera
        private Object[] lidars; //ILidar
        private UltraSonicSensor[] ultraSonics;
        private VehicleType type;

        public Builder chassis(Chassis chassis) {
            this.chassis = chassis;
            return this;
        }

        public Builder engine(Object engine) {
            this.engine = engine;
            return this;
        }

        public Builder battery(Object battery) { //IBattery
            this.battery = battery;
            return this;
        }

        public Builder headlights(Object[] lights) { //ILED
            this.headlights = lights;
            return this;
        }

        public Builder brakeLights(Object[] brakeLights) { //IBrakeLight
            this.brakeLights = brakeLights;
            return this;
        }

        public Builder indicators(Object[] indicators) { //IIndicator
            this.indicators = indicators;
            return this;
        }

        public Builder doors(Door[] doors) {
            this.doors = doors;
            return this;
        }

        public Builder seats(ISittable[] seats) {
            this.seats = seats;
            return this;
        }

        public Builder wheels(Wheel[] wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder brakes(Object[] brakes) { //IBrake
            this.brakes = brakes;
            return this;
        }

        public Builder gps(Object[] gps) { //IGPS
            this.gps = gps;
            return this;
        }

        public Builder cameras(Object[] cameras) { //ICamera
            this.cameras = cameras;
            return this;
        }

        public Builder lidars(Object[] lidars) { //ILidar
            this.lidars = lidars;
            return this;
        }

        public Builder ultraSonics(UltraSonicSensor[] us) {
            this.ultraSonics = us;
            return this;
        }

        public Builder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public AutonomousVehicle build() {
            return new AutonomousVehicle(this);
        }
    }
}