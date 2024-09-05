package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.CustomizeTheFeedScreen;
import screens.ExploreScreen;
import screens.FirstOnboardingScreen;
import screens.components.CustomizeFeedBanner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Epic("Кастомизация новостной ленты")
@Story("Настройка отображаемых блоков")
@Feature("Кастомизация новостной ленты")
@DisplayName("Проверка кастомизации новостей")
public class CustomizeFeedTests extends TestBase {
    FirstOnboardingScreen firstOnboardingScreen = new FirstOnboardingScreen();
    ExploreScreen exploreScreen = new ExploreScreen();
    CustomizeFeedBanner customizeFeedBanner = new CustomizeFeedBanner();
    CustomizeTheFeedScreen customizeTheFeedScreen = new CustomizeTheFeedScreen();

    @Owner("rybinaa")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @DisplayName("Выключенный тип контента не должен отображаться на экране \"Explore\"")
    void disabledContentShouldNotBeDisplayedOnTheExploreScreen() {
        step("Пропустить онбординг", () -> {
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            firstOnboardingScreen.clickSkipButton();
        });
        step("Нажать кнопку \"Customize\" в баннере", () -> {
//            $(id("org.wikipedia.alpha:id/view_announcement_action_positive")).click();
            customizeFeedBanner.clickCustomizeButton();
        });
        step("Нажать на тогл категории", () -> {
//            $(accessibilityId("Featured article, Daily featured article on Wikipedia"))
//                    .$(id("org.wikipedia.alpha:id/feed_content_type_checkbox")).click();
            customizeTheFeedScreen.setFeaturedArticleToggle();
        });
        step("Проверить, что категория не отображается на экране \"Explore\"", () -> {
//            $(className("android.widget.ImageButton")).click();
//            $(id("org.wikipedia.alpha:id/view_featured_article_card_header"))
//                    .shouldNotBe(visible);
            customizeTheFeedScreen.clickBackButton();
            exploreScreen.checkFeaturedArticleCardIsNotVisible();
        });
    }
}