package builder;

import components.Door;
import observer.UltraSonicSensor;

//TODO import classes
public class AutonomousVehicle {
    private final Chassis chassis;
    private final Object engine;
    private final Object battery; //IBattery
    private final Object[] headlights; //ILED
    private final Object[] breakLights; //IBrakeLight
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

    private AutonomousVehicle(Builder builder) {
        chassis = builder.chassis;
        engine = builder.engine;
        battery = builder.battery;
        headlights = builder.headlights;
        breakLights = builder.breakLights;
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
    }

    public VehicleType getType() {
        return type;
    }

    public class Builder {
        private Chassis chassis;
        private Object engine;
        private Object battery; //IBattery
        private Object[] headlights; //ILED
        private Object[] breakLights; //IBrakeLight
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
            this.breakLights = brakeLights;
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