package tests;

import data.TestData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка поиска в приложении Wiki")
public class SearchTests extends TestBase {

    TestData data = new TestData();

    @Test
    @DisplayName("Успешный поиск по поисковому запросу")
    void successfulSearchTest() {

        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            //$(id("org.wikipedia.alpha:id/wiki_language_title")).click();
//            $(id("org.wikipedia.alpha:id/wikipedia_languages_recycler"))
//                    .find(byText("Add language")).click();
            $$(id("org.wikipedia.alpha:id/wiki_language_title"))
                    .findBy(text("Add language")).click();
        });
        step("Нажать на Русский язык в списке", () -> {
//            $(id("org.wikipedia.alpha:id/languages_list_recycler")).find(byText("Русский"))
//                    .click();
            $$(id("org.wikipedia.alpha:id/localized_language_name"))
                    .findBy(text("Русский")).click();
        });
        step("Нажать на кнопку назад", () -> {
            $(className("android.widget.ImageButton")).click();
        });

        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();

        step("Вводим поисковый запрос в серч бар", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/horizontal_scroll_languages"))
                    .find(byText("RUSSIAN")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Достоевский");
            //$(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(data.searchTerm);
        });
        step("Проверяем результаты поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Disabled
    @DisplayName("Открытие первой статьи в результатах поиска")
    void openArticleTest() {
        step("Вводим поисковый запрос в серч бар", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(data.searchTerm);

        });
        step("Проверяем результаты поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0))
        );
        step("Нажимаем на первую статью в списке результата поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click()
        );
        step("Проверяем открытие страницы статьи", () ->
                $(byClassName("android.widget.TextView")).shouldHave(text(data.errorMessage))
        );

    }

    @Test
    @Disabled
    @DisplayName("Проверка краткого описания статьи")
    void checkDescriptionTest() {
        step("Вводим поисковый запрос в серч бар", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(data.searchTerm);
        });

        step("Проверяем, что найденный заголовок имеет корректное описание", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_description"))
                        .shouldHave(text(data.description)));
    }
}