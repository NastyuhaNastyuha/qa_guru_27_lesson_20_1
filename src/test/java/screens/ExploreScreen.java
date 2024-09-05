package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ExploreScreen {
    private final SelenideElement wikipediaHeader = $(id("org.wikipedia.alpha:id/main_toolbar_wordmark"));
    private final SelenideElement featuredArticleCard =
            $(id("org.wikipedia.alpha:id/view_featured_article_card_header"));
    private final SelenideElement searchButton = $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection languageCodes = $$(id("org.wikipedia.alpha:id/langCodeText"));

    public void checkWikipediaHeader() {
        wikipediaHeader.shouldBe(visible);
    }

    public void checkFeaturedArticleCardIsNotVisible() {
        featuredArticleCard.shouldNotBe(visible);
    }

    public void findArticlesInSearchWithChosenLanguage (String languageCode, String searchTerm) {
        searchButton.click();
        languageCodes.findBy(text(languageCode)).click();
        searchInput.sendKeys(searchTerm);
    }
}
