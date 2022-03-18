package tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static uis.MainScreen.*;

public class EnterText implements Task {

    Map<String, String> data;

    public EnterText(Map<String, String> data) {
        this.data = data;
    }

    public static EnterText onTheScreen(Map<String, String> data) {
        return instrumented(EnterText.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(data.get("latitude")).into(TXT_LAT));
        actor.attemptsTo(Enter.theValue(data.get("longitude")).into(TXT_LNG));
        actor.attemptsTo(Click.on(BTN_SEND));
    }
}
