package tests;

import data.Language;
import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import screens.*;
import screens.components.MoreOptionsMenu;
import screens.components.NavigationTab;
import static io.qameta.allure.Allure.step;

@Epic("Онбординг")
@Story("Прохождение онбординга")
@Feature("Онбординг")
@DisplayName("Проверка онбординга")
public class OnboardingTests extends TestBase {
    FirstOnboardingScreen firstOnboardingScreen = new FirstOnboardingScreen();
    WikipediaLanguagesScreen wikipediaLanguagesScreen = new WikipediaLanguagesScreen();
    AddALanguageScreen addALanguageScreen = new AddALanguageScreen();
    NavigationTab navigationTab = new NavigationTab();
    MoreOptionsMenu moreOptionsMenu = new MoreOptionsMenu();
    SettingsScreen settingsScreen = new SettingsScreen();
    ExploreScreen exploreScreen = new ExploreScreen();

    @Owner("rybinaa")
    @Severity(SeverityLevel.NORMAL)
    @CsvFileSource(resources = "/testData/language.csv")
    @ParameterizedTest()
    @DisplayName("Язык можно добавить на экране онбординга")
    void languageShouldBeAddedOnTheOnboardingScreen(Language language) {

        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            firstOnboardingScreen.clickAddLanguageButton();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            wikipediaLanguagesScreen.clickAddLanguageButton();
        });
        step("Нажать на " + language.getName() + " язык в списке", () -> {
            addALanguageScreen.selectALanguage(language.getName());
        });
        step("Нажать на кнопку назад", () -> {
            wikipediaLanguagesScreen.clickBackButton();
        });
        step("Проверить, что выбранный язык добавлен в список", () -> {
            firstOnboardingScreen.checkAddedLanguage(language.getName());
        });
        step("Пропустить онбординг", () -> {
            firstOnboardingScreen.clickSkipButton();
        });
        step("Открыть настройки языка", () -> {
            navigationTab.clickMoreButton();
            moreOptionsMenu.clickSettingsButton();
            settingsScreen.clickWikipediaLanguagesButton();
        });
        step("Проверить, что выбранный язык добавлен в настройках", () -> {
            wikipediaLanguagesScreen.checkLanguageInList(language.getCode());
        });
    }

    @Owner("rybinaa")
    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName("Онбординг можно пропустить по кнопке \"Skip\"")
    void onboardingShouldBeSkippedByButton() {
        step("Нажать на кнопку \"Skip\"", () -> {
            firstOnboardingScreen.clickSkipButton();
        });
        step("Проверить, что отображен заголовок на главной странице", () -> {
            exploreScreen.checkWikipediaHeader();
        });
    }
}