package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.CustomizeTheFeedScreen;
import screens.ExploreScreen;
import screens.FirstOnboardingScreen;
import screens.components.CustomizeFeedBanner;

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
            firstOnboardingScreen.clickSkipButton();
        });
        step("Нажать кнопку \"Customize\" в баннере", () -> {
            customizeFeedBanner.clickCustomizeButton();
        });
        step("Нажать на тогл категории", () -> {
            customizeTheFeedScreen.setFeaturedArticleToggle();
        });
        step("Проверить, что категория не отображается на экране \"Explore\"", () -> {
            customizeTheFeedScreen.clickBackButton();
            exploreScreen.checkFeaturedArticleCardIsNotVisible();
        });
    }
}