package s05servicecenter;

public class CompanyServiceTeam extends ServiceUnit {
    private VehicleDivision division;

    @Override
    public void printInformation() {
    }

    @Override
    public boolean handleEmergency() {
        return false;
    }
}
