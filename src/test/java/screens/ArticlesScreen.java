package screens;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ArticlesScreen {
    private final ElementsCollection articlesList = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public void checkArticlesListIsNotEmpty() {
        articlesList.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}