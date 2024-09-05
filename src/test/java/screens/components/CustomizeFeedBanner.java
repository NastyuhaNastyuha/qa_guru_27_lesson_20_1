package screens.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class CustomizeFeedBanner {
    private final SelenideElement customizeButton =
            $(id("org.wikipedia.alpha:id/view_announcement_action_positive"));

    public void clickCustomizeButton() {
        customizeButton.click();
    }
}
