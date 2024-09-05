package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreen {
    private final SelenideElement wikipediaLanguagesButton = $$(id("android:id/title"))
            .findBy(text("Wikipedia languages"));

    public void clickWikipediaLanguagesButton() {
        wikipediaLanguagesButton.click();
    }
}