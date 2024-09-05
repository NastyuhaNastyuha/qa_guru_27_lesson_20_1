package tests;

import data.Language;
import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import screens.*;
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
//    @Test
    @DisplayName("Успешный поиск по поисковому запросу на выбранном языке")
    @CsvFileSource(resources = "/testData/searchTermByLanguage.csv")
    @ParameterizedTest(name = "Успешный поиск по поисковому запросу на выбранном языке {0}")
    void successfulSearchTestByChosenLanguage(Language language, String searchTerm) {
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
        step("Пропустить онбординг", () -> {
            firstOnboardingScreen.clickSkipButton();
        });
        step("Ввести поисковый запрос в строку поиска", () -> {
            exploreScreen.findArticlesInSearchWithChosenLanguage(language.getCode(), searchTerm);
        });
        step("Проверить, что найден хотя бы один результат", () ->
                articlesScreen.checkArticlesListIsNotEmpty());
    }
}