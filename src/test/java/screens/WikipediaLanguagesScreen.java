package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaLanguagesScreen {
    private final SelenideElement addLanguageButton = $$(id("org.wikipedia.alpha:id/wiki_language_title"))
            .findBy(text("Add language"));
    private final SelenideElement backButton = $(className("android.widget.ImageButton"));
    private final ElementsCollection languagesList = $$(id("org.wikipedia.alpha:id/langCodeText"));


    public void clickAddLanguageButton() {
        addLanguageButton.click();
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void checkLanguageInList(String languageCode) {
        languagesList.findBy(text(languageCode))
                .should(exist);
    }
}
