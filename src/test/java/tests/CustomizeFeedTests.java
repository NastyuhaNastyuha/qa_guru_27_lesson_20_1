package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

@DisplayName("Проверка кастомизации новостей")
public class CustomizeFeedTests extends TestBase {

    @Test
    @DisplayName("Выключенный тип контента не должен отображаться на экране \"Explore\"")
    void disabledContentShouldNotBeDisplayedOnTheExploreScreen() {
        //пропустить онбординг
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();

//        $(id("org.wikipedia.alpha:id/view_list_card_header_menu")).click();
//        $$(id("org.wikipedia.alpha:id/content")).findBy(text("Customize the feed")).click();

        $(id("org.wikipedia.alpha:id/view_announcement_action_positive")).click();
//        $(id("org.wikipedia.alpha:id/content_types_recycler"))
//                .find(byText("Featured article")).parent().parent()
//                .$(id("org.wikipedia.alpha:id/feed_content_type_checkbox")).click();
        $(accessibilityId("Featured article, Daily featured article on Wikipedia"))
                .$(id("org.wikipedia.alpha:id/feed_content_type_checkbox")).click();

        $(className("android.widget.ImageButton")).click();
        $(id("org.wikipedia.alpha:id/view_featured_article_card_header"))
                .shouldNotBe(visible);
    }
}
