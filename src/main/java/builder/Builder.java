package builder;

import bridge.IElectricEngine;

public class Builder {
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

    }
}
}
