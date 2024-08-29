package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка онбординга")
public class OnboardingTests extends TestBase {

    @Test
    @DisplayName("Язык можно добавить на экране онбординга")
    void languageShouldBeAddedOnTheOnboardingScreen() {
        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            //$(id("org.wikipedia.alpha:id/wiki_language_title")).click();
//            $(id("org.wikipedia.alpha:id/wikipedia_languages_recycler"))
//                    .find(byText("Add language")).click();
            $$(id("org.wikipedia.alpha:id/wiki_language_title")).findBy(text("Add language")).click();
        });
        step("Нажать на Русский язык в списке", () -> {
//           $(id("org.wikipedia.alpha:id/languages_list_recycler")).find(byText("Русский"))
//                   .click();
            $$(id("org.wikipedia.alpha:id/localized_language_name"))
                    .findBy(text("Русский")).click();
        });
        step("Нажать на кнопку назад", () -> {
            $(className("android.widget.ImageButton")).click();
        });
        step("Проверить, что выбранный язык добавлен в список", () -> {
            $$(id("org.wikipedia.alpha:id/option_label"))
                    .get(1).shouldHave(text("Русский"));
        });

        //пропустить онбординг
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        step("Проверить, что выбранный язык добавлен в настройках", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_more")).click();
            $(id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
            $$(id("android:id/title")).findBy(text("Wikipedia languages")).click();
            $$(id("org.wikipedia.alpha:id/langCodeText")).findBy(text("RU"))
                    .should(exist);
        });

    }

    @Test
    @DisplayName("Онбординг можно пропустить по кнопке \"Skip\"")
    void onboardingShouldBeSkippedByButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).shouldBe(Condition.visible);
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(Condition.visible);
    }
}
