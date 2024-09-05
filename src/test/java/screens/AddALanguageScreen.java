package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class AddALanguageScreen {
    private final ElementsCollection languages = $$(id("org.wikipedia.alpha:id/localized_language_name"));

    public void selectALanguage(String languageName) {
        languages.findBy(text(languageName)).click();
    }
}
