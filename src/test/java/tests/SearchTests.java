package tests;

import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Epic("Поиск")
@Story("Поиск статей")
@Feature("Поиск")
@DisplayName("Проверка поиска в приложении")
public class SearchTests extends TestBase {
    FirstOnboardingScreen firstOnboardingScreen = new FirstOnboardingScreen();
    WikipediaLanguagesScreen wikipediaLanguagesScreen = new WikipediaLanguagesScreen();
    AddALanguageScreen addALanguageScreen = new AddALanguageScreen();
    ExploreScreen exploreScreen = new ExploreScreen();
    ArticlesScreen articlesScreen = new ArticlesScreen();

    @Owner("rybinaa")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @DisplayName("Успешный поиск по поисковому запросу")
    void successfulSearchTest() {
        TestData testData = new TestData();

        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
//            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
            firstOnboardingScreen.clickAddLanguageButton();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
//            $$(id("org.wikipedia.alpha:id/wiki_language_title"))
//                    .findBy(text("Add language")).click();
            wikipediaLanguagesScreen.clickAddLanguageButton();
        });
        step("Нажать на " + testData.language.getName() + " язык в списке", () -> {
//            $$(id("org.wikipedia.alpha:id/localized_language_name"))
//                    .findBy(text(testData.language.getName())).click();
            addALanguageScreen.selectALanguage(testData.language.getName());
        });
        step("Нажать на кнопку назад", () -> {
//            $(className("android.widget.ImageButton")).click();
            wikipediaLanguagesScreen.clickBackButton();
        });
        step("Пропустить онбординг", () -> {
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            firstOnboardingScreen.clickSkipButton();
        });
        step("Ввести поисковый запрос в строку поиска", () -> {
//            $(id("org.wikipedia.alpha:id/search_container")).click();
//            $$(id("org.wikipedia.alpha:id/langCodeText"))
//                    .findBy(text(testData.language.getCode())).click();
//            $(id("org.wikipedia.alpha:id/search_src_text"))
//                    .sendKeys(testData.searchTerm);
            exploreScreen.findArticlesInSearchWithChosenLanguage(testData.language.getCode(), testData.searchTerm);
        });
        step("Проверить, что найден хотя бы один результат", () ->
//                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
//                        .shouldHave(sizeGreaterThan(0))
                articlesScreen.checkArticlesListIsNotEmpty());
    }
}