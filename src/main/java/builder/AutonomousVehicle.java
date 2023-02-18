package builder;

import bridge.IElectricEngine;

//TODO import classes
public class AutonomousVehicle {
    private final Chassis chassis;
    private final IElectricEngine engine;
    private final Object[] battery; //IBattery
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
    }

    public class Builder {
        private Chassis chassis;
        private IElectricEngine engine;
        private Object[] battery; //IBattery
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

        public Builder chassis(Chassis chassis){
            return this;
        }

        public void engine (IElectricEngine engine){

        }

        public void battery (Object battery){ //IBattery

        }

        public void headlights (Object[] lights){ //ILED

        }

        public void brakeLights (Object[] brakeLights){ //IBrakeLight

        }

        public void indicators (Object[] indicators){ //IIndicator

        }

        public void doors (Door[] doors){

        }

        public void seats (ISittable[] seats){

        }

        public void wheels (Wheel wheels){

        }

        public void brakes (Object[] brakes){ //IBrake

        }

        public void gps (Object[] gps){ //IGPS

        }

        public void cameras (Object[] cameras){ //ICamera

        }

        public void lidars (Object[] lidars){ //ILidar

        }

        public void ultraSonics (UltraSonicSensor[] us){

        }

        public AutonomousVehicle build(){
            return new AutonomousVehicle(this);
        }
    }
}