package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class FirstOnboardingScreen {
    private final SelenideElement addLanguageButton = $(id("org.wikipedia.alpha:id/addLanguageButton"));
    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final ElementsCollection languages = $$(id("org.wikipedia.alpha:id/option_label"));


    public void clickAddLanguageButton() {
        addLanguageButton.click();
    }

    public void clickSkipButton() {
        skipButton.shouldBe(visible);
        skipButton.click();
    }

    public void checkAddedLanguage(String languageName) {
        languages.get(1).shouldHave(text(languageName));
    }
}