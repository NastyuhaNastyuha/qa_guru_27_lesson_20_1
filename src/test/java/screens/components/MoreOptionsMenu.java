package screens.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MoreOptionsMenu {
    private final SelenideElement settingsButton = $(id("org.wikipedia.alpha:id/main_drawer_settings_container"));

    public void clickSettingsButton() {
        settingsButton.click();
    }
}
