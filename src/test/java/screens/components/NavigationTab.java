package screens.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class NavigationTab {
    private final SelenideElement moreButton = $(id("org.wikipedia.alpha:id/nav_tab_more"));

    public void clickMoreButton() {
        moreButton.click();
    }
}