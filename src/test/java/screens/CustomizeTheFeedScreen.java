package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class CustomizeTheFeedScreen {
    private final SelenideElement featuredArticleToggle =
            $(accessibilityId("Featured article, Daily featured article on Wikipedia"))
            .$(id("org.wikipedia.alpha:id/feed_content_type_checkbox"));
    private final SelenideElement backButton = $(className("android.widget.ImageButton"));

    public void setFeaturedArticleToggle() {
        featuredArticleToggle.click();
    }

    public void clickBackButton() {
        backButton.click();
    }
}
