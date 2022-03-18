package uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;



public class MainScreen {

    public static final Target TXT_LAT = Target
            .the("latitude text box")
            .located(By.id("com.co.consumeapi:id/lat"));

    public static final Target TXT_LNG = Target
            .the("longitude text box")
            .located(By.id("com.co.consumeapi:id/lng"));

    public static final Target BTN_SEND = Target
            .the("the button send")
            .located(By.id("com.co.consumeapi:id/btnSend"));

    public static final Target TXTBOX_COUNTRY = Target
                .the("the country name text box answer")
                .located(By.id("com.co.consumeapi:id/countryName"));

    public static final Target TOAST = Target
                .the("the toast error message")
                .located(By.xpath("/hierarchy/android.widget.Toast"));



}
