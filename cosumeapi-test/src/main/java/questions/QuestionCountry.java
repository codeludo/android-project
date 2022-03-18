package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static uis.MainScreen.*;

public class QuestionCountry implements Question<Boolean> {

    Map<String, String> data;

    public QuestionCountry(Map<String, String> data) {
        this.data = data;
    }

    public static QuestionCountry isTheCountry(Map<String, String> data) {
        return new QuestionCountry(data);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if(data.get("errorMessage").contains("False")){
            return TXTBOX_COUNTRY.resolveFor(actor).getText().contains(data.get("message"));
        } else {
            return TOAST.resolveFor(actor).getText().contains(data.get("message"));
        }

    }
}
