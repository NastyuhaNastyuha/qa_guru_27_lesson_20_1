package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class BrowserstackDriver implements WebDriverProvider {


//    private static final BrowserStackAuthConfig authConfig = ConfigFactory.create(BrowserStackAuthConfig.class,
//            System.getProperties());
    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(config.automationName())
                .setPlatformName(config.platformName())
                .setPlatformVersion(config.browserstackPlatform())
                .setDeviceName(config.browserstackDevice())
                .setFullReset(config.appFullReset())
                .setApp(config.browserstackApp())
                .setLanguage(config.appLanguage())
                .setLocale(config.appLocale());

        try {
            return new AndroidDriver(new URI("https://" + config.getUser() + ":" + config.getKey()
                    + "@" + config.browserstackUrl()).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}