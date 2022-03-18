package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TheApp {

    public WebDriver mydriver;

    public static TheApp onThePhone() {
        return new TheApp();
    }

    public WebDriver getMydriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.co.consumeapi");
        capabilities.setCapability("appActivity", "com.co.consumeapi.MainActivity");
        capabilities.setCapability("noReset", "false");// sirve para que no desinstale e instale de nuevo la app
        capabilities.setCapability("platformName", "android");

        try {
            mydriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return mydriver;
    }
}