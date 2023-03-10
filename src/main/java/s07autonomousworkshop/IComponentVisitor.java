package s07autonomousworkshop;

public interface IComponentVisitor {

    void visitLed(Object led);

    void visitIndicator(Object indicator);

    void visitBrakeLight(Object brakeLight);

    void visitBrake(Object brake);

    void visitGps(Object gps);

    void visitLidar(Object lidar);

    void visitCamera(Object camera);
}
