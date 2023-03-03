package charging_station;

import adapter.AmazonZooxChargingAdapter;
import adapter.AutoXChargingAdapter;
import adapter.IChargable;
import builder.AutonomousVehicle;
import builder.VehicleType;
import observer_S04.VehicleControlUnit;

import java.util.Stack;

public class ChargingStation {
    private Stack<Integer> energyStack;

    public ChargingStation() {
        energyStack = new Stack<>();
        for (int i = 0; i < 500000; i++) {
            energyStack.push(1);
        }
        System.out.println("Created ChargingStation with " + energyStack.size() + " amount of energy");
    }

    public void charging(AutonomousVehicle autonomousVehicle, User user, int amountOfEnergy) {
        if (autonomousVehicle.getType() == VehicleType.AUTOX) {
            plugInDevice(new AutoXChargingAdapter());
        } else if (autonomousVehicle.getType() == VehicleType.AMAZON_ZOOX) {
            plugInDevice(new AmazonZooxChargingAdapter());
        }
        finishChargingSession(autonomousVehicle.getControlUnit(), amountOfEnergy, user.getUserMemberCard());

    }

    public void plugInDevice(IChargable device) {
        device.plugIn2Pin();
        System.out.println("Device is plugged in");
    }

    public void finishChargingSession(VehicleControlUnit vehicleControlUnit, int amountOfEnergy, UserMemberCard userMemberCard) {
        boolean enoughCreditsForChargingSuccess;
        if ((getEnergyStack().size() - amountOfEnergy) >= 0) {
            enoughCreditsForChargingSuccess = userMemberCard.getLoyaltyState().addCharging(amountOfEnergy);
            if (enoughCreditsForChargingSuccess) {
                for (int i = 0; i < amountOfEnergy; i++) {
                    energyStack.pop();
                }
                vehicleControlUnit.charging(amountOfEnergy);
                userMemberCard.getLoyaltyState().promote();
            } else System.out.println("Cancelled charging because card has not enough credits");
        } else System.out.println("Charging station does not contain enough energy for this charging session");
    }

    public Stack<Integer> getEnergyStack() {
        return energyStack;
    }

    public void setEnergyStack(Stack<Integer> energyStack) {
        this.energyStack = energyStack;
    }
}
