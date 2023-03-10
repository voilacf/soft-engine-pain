package s07autonomousworkshop;

import s01components.control_units.ComponentUtils;
import s02builder.AutonomousVehicle;
import s02builder.VehicleType;

public class WorkshopRoboter implements IComponentVisitor {
    private final boolean isLeft;
    private final ComponentStorage[] componentStorages;
    private AutonomousVehicle vehicle;

    public WorkshopRoboter(boolean isLeft) {
        this.isLeft = isLeft;

        componentStorages = new ComponentStorage[ComponentType.values().length];
        for (int i = 0; i < componentStorages.length; i++) {
            componentStorages[i] = new ComponentStorage(ComponentType.values()[i]);
        }
    }

    public void doMaintenance(AutonomousVehicle vehicle) {
        System.out.println("WorkshopRoboter " + (isLeft ? "left" : "right") + " is doing maintenance on vehicle " + vehicle);
        this.vehicle = vehicle;

        if (isLeft) {
            ComponentUtils.invokeMethod(vehicle.getHeadlights()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getIndicators()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakeLights()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakes()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakes()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getGps()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getLidars()[0], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getLidars()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getCameras()[0], "accept", new Class[]{Object.class}, this);
            if (vehicle.getType() == VehicleType.AMAZON_ZOOX)
                ComponentUtils.invokeMethod(vehicle.getCameras()[1], "accept", new Class[]{Object.class}, this);
        } else {
            ComponentUtils.invokeMethod(vehicle.getHeadlights()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getIndicators()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakeLights()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakes()[2], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getBrakes()[3], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getGps()[1], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getLidars()[2], "accept", new Class[]{Object.class}, this);
            ComponentUtils.invokeMethod(vehicle.getLidars()[3], "accept", new Class[]{Object.class}, this);
            if (vehicle.getType() == VehicleType.AMAZON_ZOOX) {
                ComponentUtils.invokeMethod(vehicle.getCameras()[2], "accept", new Class[]{Object.class}, this);
                ComponentUtils.invokeMethod(vehicle.getCameras()[3], "accept", new Class[]{Object.class}, this);
            } else {
                ComponentUtils.invokeMethod(vehicle.getCameras()[1], "accept", new Class[]{Object.class}, this);
            }
        }
    }

    @Override
    public void visitLed(Object led) {
        if (Math.random() < 0.05) {
            System.out.println("A led is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.LED.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getHeadlights()[0]);
                vehicle.getHeadlights()[0] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getHeadlights()[1]);
                vehicle.getHeadlights()[1] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitIndicator(Object indicator) {
        if (Math.random() < 0.05) {
            System.out.println("A indicator is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.INDICATOR.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getIndicators()[0]);
                vehicle.getIndicators()[0] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getIndicators()[1]);
                vehicle.getIndicators()[1] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitBrakeLight(Object brakeLight) {
        if (Math.random() < 0.05) {
            System.out.println("A brake light is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.BRAKELIGHT.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getBrakeLights()[0]);
                vehicle.getBrakeLights()[0] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getBrakeLights()[1]);
                vehicle.getBrakeLights()[1] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitBrake(Object brake) {
        if (Math.random() < 0.05) {
            System.out.println("A brake is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.BRAKE.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getBrakes()[0]);
                vehicle.getBrakes()[0] = stor.getNewComponent();
                stor.addDefectiveComponent(vehicle.getBrakes()[1]);
                vehicle.getBrakes()[2] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getBrakes()[2]);
                vehicle.getBrakes()[2] = stor.getNewComponent();
                stor.addDefectiveComponent(vehicle.getBrakes()[3]);
                vehicle.getBrakes()[3] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitGps(Object gps) {
        if (Math.random() < 0.05) {
            System.out.println("A gps is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.GPS.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getGps()[0]);
                vehicle.getGps()[0] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getGps()[1]);
                vehicle.getGps()[1] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitLidar(Object lidar) {
        if (Math.random() < 0.05) {
            System.out.println("A lidar is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.LIDAR.ordinal()];
            if (isLeft) {
                stor.addDefectiveComponent(vehicle.getLidars()[0]);
                vehicle.getLidars()[0] = stor.getNewComponent();
                stor.addDefectiveComponent(vehicle.getLidars()[1]);
                vehicle.getLidars()[1] = stor.getNewComponent();
            } else {
                stor.addDefectiveComponent(vehicle.getLidars()[2]);
                vehicle.getLidars()[2] = stor.getNewComponent();
                stor.addDefectiveComponent(vehicle.getLidars()[3]);
                vehicle.getLidars()[3] = stor.getNewComponent();
            }
        }
    }

    @Override
    public void visitCamera(Object camera) {
        if (Math.random() < 0.05) {
            System.out.println("A camera is defective and will be replaced");

            ComponentStorage stor = componentStorages[ComponentType.CAMERA.ordinal()];
            if (isLeft) {
                if(vehicle.getType() == VehicleType.AMAZON_ZOOX) {
                    stor.addDefectiveComponent(vehicle.getCameras()[0]);
                    vehicle.getCameras()[0] = stor.getNewComponent();
                    stor.addDefectiveComponent(vehicle.getCameras()[1]);
                    vehicle.getCameras()[1] = stor.getNewComponent();
                } else {
                    stor.addDefectiveComponent(vehicle.getCameras()[0]);
                    vehicle.getCameras()[0] = stor.getNewComponent();
                }
            } else {
                if(vehicle.getType() == VehicleType.AMAZON_ZOOX) {
                    stor.addDefectiveComponent(vehicle.getCameras()[2]);
                    vehicle.getCameras()[2] = stor.getNewComponent();
                    stor.addDefectiveComponent(vehicle.getCameras()[3]);
                    vehicle.getCameras()[3] = stor.getNewComponent();
                } else {
                    stor.addDefectiveComponent(vehicle.getCameras()[1]);
                    vehicle.getCameras()[1] = stor.getNewComponent();
                }
            }
        }
    }
}
