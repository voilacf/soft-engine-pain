package builder;

import bridge.IElectricEngine;

//TODO import classes
public class AutonomousVehicle {
    private final Chassis chassis;
    private final IElectricEngine engine;
    private final IBattery battery;
    private final ILED[] headlights;
    private final IBrakeLight[] breakLights;
    private final IIndicator[] indicators;
    private final Door[] doors;
    private final ISittable[] seats;
    private final Wheel[] wheels;
    private final IBrake[] brakes;
    private final IGPS[] gps;
    private final ICamera[] cameras;
    private final ILidar[] lidars;
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
        private IBattery battery;
        private ILED[] headlights;
        private IBrakeLight[] breakLights;
        private IIndicator[] indicators;
        private Door[] doors;
        private ISittable[] seats;
        private Wheel[] wheels;
        private IBrake[] brakes;
        private IGPS[] gps;
        private ICamera[] cameras;
        private ILidar[] lidars;
        private UltraSonicSensor[] ultraSonics;

        public Builder chassis(Chassis chassis){
            return this;
        }

        public void engine (IElectricEngine engine){

        }

        public void battery (IBattery battery){

        }

        public void headlights (ILED[] lights){

        }

        public void brakeLights (IBrakeLight[] brakeLights){

        }

        public void indicators (IIndicator[] indicators){

        }

        public void doors (Door[] doors){

        }

        public void seats (ISittable[] seats){

        }

        public void wheels (Wheel wheels){

        }

        public void brakes (IBrake[] brakes){

        }

        public void gps (IGPS[] gps){

        }

        public void cameras (ICamera[] cameras){

        }

        public void lidars (ILidar[] lidars){

        }

        public void ultraSonics (UltraSonicSensor[] us){

        }

        public AutonomousVehicle build(){
            return new AutonomousVehicle(this);
        }
    }
}

