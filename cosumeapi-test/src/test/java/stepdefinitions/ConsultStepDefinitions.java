package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import questions.QuestionCountry;
import tasks.EnterText;
import utils.TheApp;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultStepDefinitions {

    @Given("that I open the consumeAPI")
    public void thatIOpenTheConsumirapi() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Tester");
        theActorInTheSpotlight().can(BrowseTheWeb.with(TheApp.onThePhone().getMydriver()));
    }

    @When("I send the data")
    public void iSendTheData(Map<String, String> data) {
        theActorInTheSpotlight().attemptsTo(EnterText.onTheScreen(data));
    }
    @Then("I should see the following message")
    public void iShouldSeeTheFollowingMessage(Map<String, String> data) {
        theActorInTheSpotlight().should(seeThat(QuestionCountry.isTheCountry(data),
                Matchers.equalTo(Boolean.TRUE)));
    }
}
