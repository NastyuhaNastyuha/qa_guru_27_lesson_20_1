package tests;

import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    TestData data = new TestData();

    @Owner("rybinaa")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @DisplayName("Успешный поиск по поисковому запросу")
    void successfulSearchTest() {
        TestData testData = new TestData();

        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            $$(id("org.wikipedia.alpha:id/wiki_language_title"))
                    .findBy(text("Add language")).click();
        });
        step("Нажать на " + testData.language.getName() + " язык в списке", () -> {
            $$(id("org.wikipedia.alpha:id/localized_language_name"))
                    .findBy(text(testData.language.getName())).click();
        });
        step("Нажать на кнопку назад", () -> {
            $(className("android.widget.ImageButton")).click();
        });
        step("Пропустить онбординг", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Ввести поисковый запрос в строку поиска", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $$(id("org.wikipedia.alpha:id/langCodeText"))
                    .findBy(text(testData.language.getCode())).click();
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys(testData.searchTerm);
        });
        step("Проверить, что найдет хотя бы один результат", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}