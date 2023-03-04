package s01.indicator;

import control_unit.IndicatorControlUnit;
import factories.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IndicatorStepdefs {
    private Object[] indicatorPort = new Object[2]; //TODO: change to four??
    private IndicatorControlUnit controlUnit;

    @Given("My autonomous vehicle contains two indicators")
    public void myVehicleContainsAnIndicator(){
        indicatorPort[0] = ComponentFactory.buildIndicator();
        indicatorPort[1] = ComponentFactory.buildIndicator();
    }

    @Then("The indicator components should not be null")
    public void indicatorComponentShouldNotBeNull(){
        assertNotNull(indicatorPort[0]);
        assertNotNull(indicatorPort[1]);
    }

    @Given("I have an indicator component and its control unit")
    public void iHaveAIndicatorAndItsControlUnit(){
        indicatorPort[0] = ComponentFactory.buildIndicator();
        controlUnit = new IndicatorControlUnit(indicatorPort);
    }

    //TODO: finish
    @When("The indicator control unit receives an left indicator on event")
    public void indicatorControlUnitReceivesAnLeftIndicatorOnEvent() {

    }

    @Then("The left indicator is turned on")
    public void leftIndicatorIsTurnedOn() {
        //assertEquals();
    }

    @When("The indicator control unit receives an left indicator off event")
    public void indicatorControlUnitReceivesAnLeftIndicatorOffEvent() {

    }

    @Then("The left indicator is turned off")
    public void leftIndicatorIsTurnedOff() {
        //assertEquals();
    }

    @When("The indicator control unit receives an right indicator on event")
    public void indicatorControlUnitReceivesAnRightIndicatorOnEvent() {

    }

    @Then("The right indicator is turned on")
    public void rightIndicatorIsTurnedOn() {
        //assertEquals();
    }

    @When("The indicator control unit receives an right indicator off event")
    public void indicatorControlUnitReceivesAnRightIndicatorOffEvent() {

    }

    @Then("The right indicator is turned off")
    public void rightIndicatorIsTurnedOff() {
        //assertEquals();
    }

    @When("The indicator control unit receives an hazard on event")
    public void indicatorControlUnitReceivesAnHazardOnEvent() {

    }

    @Then("The indicator hazard is turned on")
    public void indicatorHazardIsOn() {
        //assertEquals();
    }

    @When("The indicator control unit receives an hazard off event")
    public void indicatorControlUnitReceivesAnHazardOffEvent() {

    }

    @Then("The indicator hazard is turned off")
    public void indicatorHazardIsOff() {
        //assertEquals();
    }
}
