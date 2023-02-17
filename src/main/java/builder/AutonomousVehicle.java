package builder;

import bridge.IElectricEngine;

public class AutonomousVehicle {
    private Chassis chassis;
    private IElectricEngine engine;
    //private IBattery battery; //TODO: Import class
    //ILED[] headlights; //TODO: Import class
    //IBrakeLight[] breaklights; //TODO: Import class
    //IIndicator[] indicators; //TODO: Import class
    Door[] doors;
    ISittable[] seats;
    Wheel[] wheels;
    //IBrake[] brakes; //TODO: Import class
    //IGPS[] gps; //TODO: Import class
    //ICamera[] cameras; //TODO: Import class
    //ILidar[] lidars; //TODO: Import class
    UltraSonicSensor[] ultraSonics;
}
