package service_center;

public class CompanyServiceTeam extends ServiceUnit{
    private VehicleDivision division;

    @Override
    public void printInformation() {}

    @Override
    public boolean handleEmergency() {
        return false;
    }
}
