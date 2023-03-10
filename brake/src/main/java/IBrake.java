public interface IBrake {
    void setBrake(double percentage);
    double getPercentage();
    void accept(Object visitor);
}
