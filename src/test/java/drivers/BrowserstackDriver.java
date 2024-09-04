package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.getUser());
        caps.setCapability("browserstack.key", authConfig.getKey());
        caps.setCapability("app", browserstackConfig.getApp());
        caps.setCapability("device", browserstackConfig.getDevice());
        caps.setCapability("platform.version", browserstackConfig.getOsVersion());
        caps.setCapability("project", browserstackConfig.getProject());
        caps.setCapability("build", browserstackConfig.getBuild());
        caps.setCapability("name", browserstackConfig.getName());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getBrowserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}